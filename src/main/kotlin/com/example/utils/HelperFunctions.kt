package com.example.utils

import Violation
import com.example.configurations.objectMapper
import io.ktor.server.plugins.requestvalidation.*
import java.util.*

fun String.toUuidOrNull(): UUID? = runCatching { UUID.fromString(this) }.getOrNull()

fun MutableList<Violation>.toValidationResult(): ValidationResult = when (size) {
    0 -> ValidationResult.Valid
    else -> ValidationResult.Invalid(map { it.message })
}

fun Any?.mapToJson(): String = objectMapper.writeValueAsString(this)
