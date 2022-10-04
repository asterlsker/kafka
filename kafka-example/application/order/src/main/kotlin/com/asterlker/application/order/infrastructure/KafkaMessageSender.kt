package com.asterlker.application.order.infrastructure

import com.asterlker.application.order.application.MessageSender
import com.asterlker.common.domain.messages.OrderMessage
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.kafka.support.SendResult
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class KafkaMessageSender(
    private val kafkaTemplate: KafkaTemplate<String, OrderMessage>
) : MessageSender {

    private val log = LoggerFactory.getLogger(this::class.java)

    companion object {
        const val TOPIC_NAME = "dev.asterisk.order.json"
    }

    override fun send(registeredOrder: OrderMessage) {
        val message = MessageBuilder.withPayload(registeredOrder)
            .setHeader(KafkaHeaders.TOPIC, TOPIC_NAME)
            .build()

        val future = kafkaTemplate.send(message)
        future.addCallback(object : ListenableFutureCallback<SendResult<String, OrderMessage>> {
            override fun onSuccess(result: SendResult<String, OrderMessage>?) {
                log.info(
                    "Sent message = [ ${
                        result?.producerRecord?.value().toString()
                    } with offset ${result?.recordMetadata?.offset()}"
                )
            }

            override fun onFailure(ex: Throwable) {
                log.error("Unable to send message due to: ${ex.message}")
            }
        })
    }
}