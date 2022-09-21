package com.asterlker.application.message.infrastructure

import com.asterlker.application.message.domain.order.OrderConsumer
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class OrderConsumerImpl: OrderConsumer {

    @KafkaListener(topics = ["dev.asterisk.order.json"], groupId = "dev.asterisk.order.by.message")
    override fun bringMessage(message: String): String {
        return message;
    }

}