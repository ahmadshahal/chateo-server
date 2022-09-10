package com.kotmaster.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Message(
    @SerialName("id")
    val id: Int,
    @SerialName("sender_user_name")
    val senderUsername: String,
    @SerialName("text")
    val text: String,
)
