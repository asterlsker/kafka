package com.asterlker.application.message.domain.order

import com.asterlker.application.message.common.model.OrderStatus

data class OrderMessage (
        val orderId: Long,
        val name: String,
        val quantity: Int,
        val price: Int,
        val status: OrderStatus,
        val userId: Long
        ) {
}