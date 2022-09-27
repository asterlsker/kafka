package com.asterlker.application.order.application

import com.asterlker.application.order.interfaces.dto.OrderPublisher
import org.springframework.stereotype.Component

@Component
class OrderFacade(
    private val messageSender: MessageSender
) {

    fun register(registeredOrder: OrderPublisher.RegisteredMessage) {
        messageSender.send(registeredOrder)
    }
}