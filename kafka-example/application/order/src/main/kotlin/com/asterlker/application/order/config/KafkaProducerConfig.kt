package com.asterlker.application.order.config

import com.asterlker.application.order.interfaces.dto.OrderPublisher
import com.asterlker.common.domain.messages.OrderMessage
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
class KafkaProducerConfig {

    companion object {
        val BOOT_STRAP_SERVERS = listOf("localhost:9092")
    }

    @Bean
    fun kafkaTemplate() = KafkaTemplate(producerFactory())

    @Bean
    fun producerFactory(): ProducerFactory<String, OrderMessage> =
        DefaultKafkaProducerFactory(producerFactoryConfig())

    private fun producerFactoryConfig() =
        mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to BOOT_STRAP_SERVERS,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java
        )
}