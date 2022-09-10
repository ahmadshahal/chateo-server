package com.kotmaster.plugins

import com.kotmaster.routes.chatRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        chatRouting()
    }
}
