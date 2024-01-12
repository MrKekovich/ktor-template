package com.example

import com.example.configurations.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
//    configureSecurity() // TODO: Configure security
    configureHTTP()
    configureSerialization()
    configureDatabases()
    configureSockets()
    configureRouting()
    configureStatusPages()
}
