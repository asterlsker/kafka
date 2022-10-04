package com.asterlker.application.logging

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(
    scanBasePackages = ["com.asterlker.application.logging"]
)
class LoggingApplication

fun main(args: Array<String>) {
    System.setProperty("spring.profiles.default", "local")
    runApplication<LoggingApplication>(*args)
}