package com.asterlker.application.message

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["com.asterlker.application.message"]
)
class MessageApplication

fun main(args: Array<String>) {
    System.setProperty("spring.profiles.default", "local")
    runApplication<MessageApplication>(*args)
}