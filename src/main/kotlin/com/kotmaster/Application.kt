package com.kotmaster

import com.kotmaster.di.dataSourcesModule
import com.kotmaster.di.repositoriesModule
import com.kotmaster.plugins.configureMonitoring
import com.kotmaster.plugins.configureRouting
import com.kotmaster.plugins.configureSerialization
import com.kotmaster.plugins.configureSockets
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(Koin) {
        modules(repositoriesModule, dataSourcesModule)
    }
    configureSockets()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
