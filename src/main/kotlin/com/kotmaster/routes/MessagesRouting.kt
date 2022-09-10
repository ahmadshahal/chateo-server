package com.kotmaster.routes

import com.kotmaster.data.repositories.MessagesRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.messagesRouting() {

    val messagesRepository: MessagesRepository by inject()

    get("/messages") {
        call.respond(messagesRepository.getMessages())
    }
}