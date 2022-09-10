package com.kotmaster.data.database.tables

import org.jetbrains.exposed.sql.Table

object Messages : Table() {
    val id = integer("id").autoIncrement()
    val senderUsername = varchar("sender_username", 128)
    val text = varchar("text", 1024)

    override val primaryKey = PrimaryKey(id)
}