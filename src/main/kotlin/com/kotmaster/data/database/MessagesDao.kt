package com.kotmaster.data.database

import com.kotmaster.data.database.tables.Messages
import com.kotmaster.data.models.Message
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

interface MessagesDao {
    suspend fun getMessages(): List<Message>
    suspend fun insertMessage(message: Message)
}

class MessagesDaoImpl : MessagesDao {

    private fun resultRowToMessage(resultRow: ResultRow) = Message(
        id = resultRow[Messages.id],
        senderUsername = resultRow[Messages.senderUsername],
        text = resultRow[Messages.senderUsername]
    )

    override suspend fun getMessages(): List<Message> = dbQuery {
        Messages.selectAll().map { resultRowToMessage(it) }
    }

    override suspend fun insertMessage(message: Message): Unit = dbQuery {
        Messages.insert {
            it[id] = message.id
            it[senderUsername] = message.senderUsername
            it[text] = message.text
        }
    }
}