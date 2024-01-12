package com.example.configurations

import com.example.configurations.DatabaseConfiguration.driver
import com.example.configurations.DatabaseConfiguration.password
import com.example.configurations.DatabaseConfiguration.url
import com.example.configurations.DatabaseConfiguration.username
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction


fun configureDatabases() {
    val database = Database.connect(
        driver = driver,
        url = url,
        user = username,
        password = password,
    )
    transaction(database) {
        // TODO: Initialize database
    }
}
