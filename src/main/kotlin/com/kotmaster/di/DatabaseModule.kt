package com.kotmaster.di

import com.kotmaster.data.database.MessagesDao
import com.kotmaster.data.database.MessagesDaoImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        MessagesDaoImpl()
    } bind MessagesDao::class
}