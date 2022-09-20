package com.asterlker.application.order.config

import com.asterlker.application.order.interfaces.dto.OrderProducer
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
        const val BOOT_STRAP_SERVERS = "127.0.0.1:9091"
    }

    @Bean
    fun kafkaTemplate() = KafkaTemplate(producerFactory())

    @Bean
    fun producerFactory(): ProducerFactory<String, OrderProducer.RegisteredOrder> =
        DefaultKafkaProducerFactory(producerFactoryConfig())

    private fun producerFactoryConfig(): Map<String, Any>  =
        HashMap<String, Any>().apply {
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to BOOT_STRAP_SERVERS
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java
        }
}