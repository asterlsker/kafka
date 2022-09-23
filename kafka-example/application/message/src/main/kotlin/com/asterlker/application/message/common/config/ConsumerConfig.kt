package com.asterlker.application.message.common.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
class ConsumerConfig {

    companion object {
        const val HOST_NAME = "localhost:9092"
    }

    @Bean
    fun listenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()

        factory.setConcurrency(2)
        factory.consumerFactory = DefaultKafkaConsumerFactory(getProps())
        factory.containerProperties.pollTimeout = 500

        return factory
    }

    private fun getProps(): Map<String, Any> =
            mapOf(
                    ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to HOST_NAME,
                    ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "latest",
                    ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class,
                    ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class
            )
}