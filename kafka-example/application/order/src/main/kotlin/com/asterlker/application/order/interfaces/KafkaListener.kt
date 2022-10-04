package com.asterlker.application.order.interfaces

import com.asterlker.application.order.interfaces.dto.DeliverySubscriber
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class KafkaListener {

    private val log = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(
        topics = ["dev.asterisk.delivery.json"],
        groupId = "dev.asterisk.delivery.by.order",
        containerFactory = "deliveryKafkaListenerContainerFactory")
    fun listenWithHeaders(
        @Payload payload: DeliverySubscriber.DeliveryProcessMessage,
        @Headers messageHeaders: MessageHeaders
    ) {
        log.info("Received Message: $payload and Headers: $messageHeaders")
    }
}