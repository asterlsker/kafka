package com.asterlker.application.message.common.config

import com.asterlker.application.message.common.record.PushMessageRecord
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
class ProducerConfig {

    companion object {
        const val HOST_NAME = "kafka:9092"
    }

    @Bean
    fun kafkaProducer(): KafkaProducer<String, PushMessageRecord> {
        return KafkaProducer<String, PushMessageRecord>(getProps())
    }

    private fun getProps(): Map<String, Any> =
            mapOf(
                    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to HOST_NAME,
                    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
                    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java
            )
}