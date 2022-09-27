package com.asterlker.application.order.application

import com.asterlker.application.order.interfaces.dto.OrderPublisher

interface MessageSender {
    fun send(registeredOrder: OrderPublisher.RegisteredMessage)
}