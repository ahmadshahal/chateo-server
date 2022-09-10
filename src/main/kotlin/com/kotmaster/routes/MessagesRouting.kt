package com.kotmaster.routes

import com.kotmaster.data.sources.MessagesDataSource
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.messagesRouting() {

    val messagesDataSource: MessagesDataSource by inject()

    get("/messages") {
        call.respond(messagesDataSource.getMessages())
    }
}