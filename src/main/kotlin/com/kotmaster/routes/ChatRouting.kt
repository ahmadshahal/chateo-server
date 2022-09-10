package com.kotmaster.routes

import com.kotmaster.controllers.RoomController
import com.kotmaster.data.models.Message
import com.kotmaster.exceptions.UsernameAlreadyExitsException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.inject

fun Route.chatRouting() {
    val roomController: RoomController by inject()

    get("/messages") {
        call.respond(roomController.getMessages())
    }

    webSocket("/chat/{username?}") {
        val username = call.parameters["username"]
            ?: return@webSocket call.respondText(
                text = "Missing Username",
                status = HttpStatusCode.BadRequest
            )
        try {
            roomController.onJoin(username, this)
            for (frame in incoming) {
                frame as? Frame.Text ?: continue
                val receivedText = frame.readText()
                val message: Message = Json.decodeFromString(Message.serializer(), receivedText)
                roomController.sendMessage(message)
            }
            roomController.tryDisconnect(username)
        } catch (ex: UsernameAlreadyExitsException) {
            call.respondText(text = ex.message!!, status = HttpStatusCode.Conflict)
            close()
        } catch (ex: Exception) {
            ex.printStackTrace()
            roomController.tryDisconnect(username)
        }
    }
}