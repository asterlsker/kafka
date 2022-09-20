package com.asterlker.application.order.application

import com.asterlker.application.order.interfaces.dto.OrderProducer
import org.springframework.stereotype.Component

@Component
class OrderFacade(
    private val messageSender: MessageSender
) {

    fun register(registeredOrder: OrderProducer.RegisteredOrder) {
        messageSender.send(registeredOrder)
    }
}