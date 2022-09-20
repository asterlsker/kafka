package com.asterlker.application.order.application

import com.asterlker.application.order.interfaces.dto.OrderProducer

interface MessageSender {
    fun send(registeredOrder: OrderProducer.RegisteredOrder)
}