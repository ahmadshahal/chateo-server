package com.kotmaster

import com.kotmaster.plugins.configureMonitoring
import com.kotmaster.plugins.configureRouting
import com.kotmaster.plugins.configureSerialization
import com.kotmaster.plugins.configureSockets
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSockets()
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
