package com.example.configurations

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.configurations.SecurityConfiguration.jwtAudience
import com.example.configurations.SecurityConfiguration.jwtDomain
import com.example.configurations.SecurityConfiguration.jwtRealm
import com.example.configurations.SecurityConfiguration.jwtSecret
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureSecurity() {
    authentication {
        jwt {
            realm = jwtRealm
            verifier(
                JWT
                    .require(Algorithm.HMAC256(jwtSecret))
                    .withAudience(jwtAudience)
                    .withIssuer(jwtDomain)
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null
            }
        }
    }
}
