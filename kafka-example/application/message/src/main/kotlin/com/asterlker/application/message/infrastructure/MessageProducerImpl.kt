package com.asterlker.application.message.infrastructure

import com.asterlker.application.message.domain.message.MessageProducer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

class MessageProducerImpl(
        private val kafkaProducer: KafkaProducer<String, String>
): MessageProducer {

    companion object {
        const val TOPIC_NAME = "dev.asterisk.message.json"
    }

    override fun sendMessage(message: String) {
        val record = ProducerRecord<String, String>(TOPIC_NAME, message)
        kafkaProducer.send(record)
    }
}