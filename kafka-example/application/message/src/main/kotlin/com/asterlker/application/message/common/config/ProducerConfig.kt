package com.asterlker.application.message.common.config

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProducerConfig {

    companion object {
        const val HOST_NAME = "localhost:9092"
    }

    @Bean
    fun kafkaProducer(): KafkaProducer<String, String> {
        return KafkaProducer<String, String>(getProps())
    }

    private fun getProps(): Map<String, Any> =
            mapOf(
                    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to HOST_NAME,
                    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
                    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
            )
}