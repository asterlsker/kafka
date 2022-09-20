package com.asterlker.application.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
@SpringBootApplication(
    scanBasePackages = [
        "com.asterlker.application.order",
        "com.asterlker.common.domain"
    ]
)
@EnableJpaRepositories(basePackages = ["com.asterlker.common.domain"])
@EntityScan(basePackages = ["com.asterlker.common.domain"])
class OrderApplication

fun main(args: Array<String>) {
    System.setProperty("spring.profiles.default", "local")
    runApplication<OrderApplication>(*args)
}