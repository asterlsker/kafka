package com.asterlker.application.order.interfaces.dto

import com.asterlker.common.domain.entity.OrderStatus

class OrderPublisher {

    data class RegisteredMessage(
        val orderId: Long,
        val userId: String,
        val orderName: String,
        val quantity: String,
        val price: String,
        val status: OrderStatus
    )
}