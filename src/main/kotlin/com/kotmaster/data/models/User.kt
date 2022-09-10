package com.kotmaster.data.models

import io.ktor.websocket.*

data class User(
    val userName: String,
    val socketSession: WebSocketSession,
)
