package com.kotmaster

import com.kotmaster.data.database.DatabaseFactory
import com.kotmaster.di.dataSourcesModule
import com.kotmaster.di.databaseModule
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
        modules(dataSourcesModule, databaseModule)
    }
    DatabaseFactory.init()
    configureSockets()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
