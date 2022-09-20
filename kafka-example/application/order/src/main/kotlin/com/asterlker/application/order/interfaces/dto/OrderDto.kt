package com.asterlker.application.order.interfaces.dto

import com.asterlker.common.domain.entity.OrderStatus
import java.util.UUID
import kotlin.random.Random

class OrderDto {

    data class RegisterRequest(
        val userId: String,
        val orderName: String,
        val quantity: String,
        val price: String,
    ) {
        fun toMessage() = OrderProducer.RegisteredOrder(
                orderId = Random.nextLong(),
                userId = UUID.randomUUID().toString().substring(0, 10),
                orderName = orderName,
                quantity = quantity,
                price = price,
                status = OrderStatus.CREATED
            )
    }
}