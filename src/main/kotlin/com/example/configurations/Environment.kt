package com.example.configurations

import io.github.cdimascio.dotenv.dotenv
import java.io.File

val environment = dotenv {
    directory = File("src/main/resources").absolutePath
    filename = "application.env"
}

object DatabaseConfiguration {
    val url: String  = environment["DATABASE_URL"]
    val username: String  = environment["DATABASE_USERNAME"]
    val password: String  = environment["DATABASE_PASSWORD"]
    val driver: String  = environment["DATABASE_DRIVER"]
}

object SecurityConfiguration {
    val jwtAudience: String = environment["JWT_AUDIENCE"]
    val jwtDomain: String = environment["JWT_DOMAIN"]
    val jwtRealm: String  = environment["JWT_REALM"]
    val jwtSecret: String  = environment["JWT_SECRET"]
}
