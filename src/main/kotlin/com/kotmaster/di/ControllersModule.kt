package com.kotmaster.di

import com.kotmaster.controllers.RoomController
import org.koin.dsl.module

val controllersModule = module {
    single { RoomController(get()) }
}