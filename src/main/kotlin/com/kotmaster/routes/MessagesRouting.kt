package com.kotmaster.routes

import com.kotmaster.data.sources.MessagesDataSourceImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.messagesRouting() {
    val messagesDataSource = MessagesDataSourceImpl()

    get("/messages") {
        call.respond(messagesDataSource.getMessages())
    }
}