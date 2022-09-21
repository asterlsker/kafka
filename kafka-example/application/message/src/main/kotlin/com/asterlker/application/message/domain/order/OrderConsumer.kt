package com.asterlker.application.message.domain.order

interface OrderConsumer {

    fun bringMessage(message: String): String
}