package com.example.configurations

import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*

fun Application.configureValidation() {
    install(RequestValidation) {
        // add your validation logic here
        // validate<YourRequestDto> { it.validate() }
    }
}