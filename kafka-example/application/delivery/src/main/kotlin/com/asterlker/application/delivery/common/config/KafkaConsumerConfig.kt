package com.asterlker.application.delivery.common.config

import com.asterlker.common.domain.messages.OrderMessage
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.ByteArrayDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.kafka.support.serializer.JsonSerializer

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    companion object {
        val bootstrapAddress = listOf("kafka:9092")
        const val groupId = "dev.asterisk.order.by.delivery"
    }

    @Bean
    fun orderKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, OrderMessage> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, OrderMessage>()
        factory.consumerFactory = orderKafkaFactory()
        return factory
    }

    @Bean
    fun orderKafkaFactory(): ConsumerFactory<String?, OrderMessage> {
        return DefaultKafkaConsumerFactory(
            getConfig(),
            StringDeserializer(),
            JsonDeserializer(OrderMessage::class.java)
        )
    }

    private fun getConfig(): Map<String, Any> =
        mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapAddress,
            ConsumerConfig.GROUP_ID_CONFIG to groupId,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonSerializer::class.java,
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "latest",
        )
}