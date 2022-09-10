package com.kotmaster.data.repositories

import com.kotmaster.data.sources.MessagesDataSource
import com.kotmaster.models.Message

class MessagesRepository(
    private val messagesDataSource: MessagesDataSource,
) {
    fun getMessages(): List<Message> =
        messagesDataSource.getMessages()

    fun insertMessage(message: Message) =
        messagesDataSource.insertMessage(message)
}