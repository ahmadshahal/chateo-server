package com.kotmaster.plugins

import com.kotmaster.routes.messagesRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        messagesRouting()

        get("/") {
            call.respondText("Hello World!")
        }
    }
}
