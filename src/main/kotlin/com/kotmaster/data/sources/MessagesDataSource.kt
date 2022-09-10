package com.kotmaster.data.sources

import com.kotmaster.data.database.MessagesDao
import com.kotmaster.data.models.Message

interface MessagesDataSource {

    suspend fun getMessages(): List<Message>

    suspend fun insertMessage(message: Message)
}

class MessagesDataSourceImpl(
    private val messagesDao: MessagesDao
) : MessagesDataSource {

    override suspend fun getMessages() = messagesDao.getMessages()

    override suspend fun insertMessage(message: Message) = messagesDao.insertMessage(message)
}
