package com.asterlker.application.delivery.interfaces.kafka

import com.asterlker.common.domain.messages.OrderMessage
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component


@Component
class DeliveryListener {
    private val log = LoggerFactory.getLogger(this.javaClass)

//    @KafkaListener(
//        topics = ["dev.asterisk.order.json"],
//        groupId = "dev.asterisk.order.by.delivery2",
//        containerFactory = "orderKafkaListenerContainerFactory"
//    )
//    fun listen1(
//        @Payload message: OrderMessage,
//        @Headers header: MessageHeaders
//    ) {
//        log.info("message: $message, header: $header")
//    }

    @KafkaListener(
        topics = ["dev.asterisk.order.json"],
        groupId = "dev.asterisk.order.by.delivery1",
        containerFactory = "orderKafkaListenerContainerFactory"
    )
    fun listen2(
        message: OrderMessage
    ) {
        log.info("message: $message")
    }
}
