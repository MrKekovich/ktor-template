package com.example.utils

import ValidationBuilder
import Violation
import com.example.configurations.objectMapper
import com.fasterxml.jackson.annotation.JsonProperty
import io.ktor.server.plugins.requestvalidation.*
import java.util.*
import kotlin.reflect.KProperty
import kotlin.reflect.full.findAnnotation

fun String.toUuidOrNull(): UUID? = runCatching { UUID.fromString(this) }.getOrNull()

fun MutableList<Violation>.toValidationResult(): ValidationResult = when (size) {
    0 -> ValidationResult.Valid
    else -> ValidationResult.Invalid(map { it.message })
}

fun Any?.mapToJson(): String = objectMapper.writeValueAsString(this)

inline fun validateAll(block: ValidationBuilder.() -> Unit): ValidationResult {
    val builder = object : ValidationBuilder() {
        override val KProperty<*>.alias: String
            get() = findAnnotation<JsonProperty>()?.value
                ?: getter.findAnnotation<JsonProperty>()?.value
                ?: name
    }
    return ValidationBuilder().apply(block).violations.toValidationResult()
}
