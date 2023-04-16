package com.learning

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.jetty.*
import com.learning.plugins.*

fun main() {
    embeddedServer(Jetty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureHTTP()
    configureRouting()
}
