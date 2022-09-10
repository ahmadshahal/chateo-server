package com.kotmaster.di

import com.kotmaster.data.repositories.MessagesRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single {
        MessagesRepository(get())
    }
}