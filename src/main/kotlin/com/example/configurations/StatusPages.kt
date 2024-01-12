package com.example.configurations

import com.example.dto.ErrorDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            val status = HttpStatusCode.InternalServerError
            call.respond(status, ErrorDto(cause.message ?: "Internal server error"))
        }

        exception<NotFoundException> { call, cause ->
            val status = HttpStatusCode.NotFound
            call.respond(status, ErrorDto(cause.message ?: "Not found"))
        }

        exception<BadRequestException> { call, cause ->
            val status = HttpStatusCode.BadRequest
            call.respond(status, ErrorDto(cause.message ?: "Bad request"))
        }
    }
}