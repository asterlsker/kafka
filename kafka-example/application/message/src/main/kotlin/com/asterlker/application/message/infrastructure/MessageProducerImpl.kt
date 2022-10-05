package com.asterlker.application.message.infrastructure

import com.asterlker.common.domain.messages.PushMessage
import com.asterlker.application.message.domain.MessageProducer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Component

@Component
class MessageProducerImpl(
        private val kafkaProducer: KafkaProducer<String, PushMessage>
): MessageProducer {

    companion object {
        const val TOPIC_NAME = "dev.asterisk.message.json"
    }

    override fun sendMessage(message: PushMessage) {
        val record = ProducerRecord<String, PushMessage>(TOPIC_NAME, message)
        kafkaProducer.send(record)
    }
}