package com.asterlker.application.message.common.config

import com.asterlker.application.message.common.record.OrderRecord
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@Configuration
class ConsumerConfig {

    companion object {
        const val HOST_NAME = "localhost:9092"
    }

    @Bean
    fun listenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, OrderRecord> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, OrderRecord>()

        factory.setConcurrency(2)
        factory.consumerFactory = DefaultKafkaConsumerFactory(getProps(), StringDeserializer(), JsonDeserializer(OrderRecord::class.java))
        factory.containerProperties.pollTimeout = 500

        return factory
    }

    private fun getProps(): Map<String, Any> =
            mapOf(
                    ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to HOST_NAME,
                    ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "latest",
            )
}