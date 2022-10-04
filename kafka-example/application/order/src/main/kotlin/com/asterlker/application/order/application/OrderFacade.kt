package com.asterlker.application.order.application

import com.asterlker.application.order.interfaces.dto.OrderPublisher
import com.asterlker.common.domain.messages.OrderMessage
import org.springframework.stereotype.Component

@Component
class OrderFacade(
    private val messageSender: MessageSender
) {

    fun register(registeredOrder: OrderMessage) {
        messageSender.send(registeredOrder)
    }
}