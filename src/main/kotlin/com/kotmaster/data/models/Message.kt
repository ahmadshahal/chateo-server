package com.kotmaster.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Message(
    @SerialName("senderUsername")
    val senderUsername: String,
    @SerialName("text")
    val text: String,
)
