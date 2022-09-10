package com.kotmaster.controllers

import com.kotmaster.data.models.Message
import com.kotmaster.data.models.User
import com.kotmaster.data.sources.MessagesDataSource
import com.kotmaster.exceptions.UsernameAlreadyExitsException
import io.ktor.websocket.*
import kotlinx.serialization.json.Json
import java.util.concurrent.ConcurrentHashMap

class RoomController(
    private val messagesDataSource: MessagesDataSource
) {
    private val users = ConcurrentHashMap<String, User>()

    fun onJoin(
        username: String,
        webSocketSession: WebSocketSession
    ) {
        if (users.containsKey(username)) {
            throw UsernameAlreadyExitsException()
        }
        users[username] = User(username, webSocketSession)
    }

    suspend fun sendMessage(message: Message) {
        messagesDataSource.insertMessage(message)
        users.values.forEach { user ->
            user.socketSession.send(
                Frame.Text(
                    Json.encodeToString(Message.serializer(), message)
                )
            )
        }
    }

    suspend fun tryDisconnect(username: String) {
        users[username]?.socketSession?.close()
        if(users.containsKey(username)) {
            users.remove(username)
        }
    }

    suspend fun getMessages() = messagesDataSource.getMessages()
}