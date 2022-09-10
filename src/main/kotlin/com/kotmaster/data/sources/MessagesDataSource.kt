package com.kotmaster.data.sources

import com.kotmaster.models.Message

interface MessagesDataSource {

    fun getMessages(): List<Message>

    fun insertMessage(message: Message)
}

class MessagesDataSourceImpl : MessagesDataSource {
    override fun getMessages(): List<Message> {
        TODO("Not yet implemented")
    }

    override fun insertMessage(message: Message) {
        TODO("Not yet implemented")
    }
}
