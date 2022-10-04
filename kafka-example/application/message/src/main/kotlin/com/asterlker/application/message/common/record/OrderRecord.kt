package com.asterlker.application.message.common.record

import com.asterlker.application.message.common.model.OrderStatus

data class OrderRecord(
        val orderId: Long,
        val name: String,
        val quantity: Int,
        val price: Int,
        val status: OrderStatus?,
        val userId: Long
        ) {
        constructor() :this(0, "", 0, 0, null, 0)
}