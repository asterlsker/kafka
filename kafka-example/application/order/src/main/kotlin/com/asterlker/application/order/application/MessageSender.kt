package com.asterlker.application.order.application

import com.asterlker.application.order.interfaces.dto.OrderPublisher
import com.asterlker.common.domain.messages.OrderMessage

interface MessageSender {
    fun send(registeredOrder: OrderMessage)
}