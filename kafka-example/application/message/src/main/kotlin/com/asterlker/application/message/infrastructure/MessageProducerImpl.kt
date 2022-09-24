package com.asterlker.application.message.infrastructure

import com.asterlker.application.message.common.record.PushMessageRecord
import com.asterlker.application.message.domain.MessageProducer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Component

@Component
class MessageProducerImpl(
        private val kafkaProducer: KafkaProducer<String, PushMessageRecord>
): MessageProducer {

    companion object {
        const val TOPIC_NAME = "dev.asterisk.message.json"
    }

    override fun sendMessage(message: PushMessageRecord) {
        val record = ProducerRecord<String, PushMessageRecord>(TOPIC_NAME, message)
        kafkaProducer.send(record)
    }
}