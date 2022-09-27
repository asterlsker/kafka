package com.asterlker.application.order.config

import com.asterlker.application.order.interfaces.dto.DeliverySubscriber
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer


@EnableKafka
@Configuration
class KafkaConsumerConfig {

    companion object {
        val BOOT_STRAP_SERVERS = listOf("localhost:9092")
        const val GROUP_ID = "dev.asterisk.delivery.by.order"
    }

    @Bean
    fun deliveryKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, DeliverySubscriber.DeliveryProcessMessage> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, DeliverySubscriber.DeliveryProcessMessage> =
            ConcurrentKafkaListenerContainerFactory<String, DeliverySubscriber.DeliveryProcessMessage>()
        return factory.apply { consumerFactory = deliveryConsumerFactory() }
    }

    @Bean
    fun deliveryConsumerFactory(): DefaultKafkaConsumerFactory<String, DeliverySubscriber.DeliveryProcessMessage> {
        val deserializer = deliveryJsonDeserializer()
        return DefaultKafkaConsumerFactory(
            deliveryConsumerFactoryConfig(deserializer),
            StringDeserializer(),
            deserializer
        )
    }

    private fun deliveryConsumerFactoryConfig(deserializer: JsonDeserializer<DeliverySubscriber.DeliveryProcessMessage>) =
        mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to BOOT_STRAP_SERVERS,
            ConsumerConfig.GROUP_ID_CONFIG to GROUP_ID,
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "latest",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to deserializer::class.java
        )

    private fun deliveryJsonDeserializer(): JsonDeserializer<DeliverySubscriber.DeliveryProcessMessage> {
        val deserializer: JsonDeserializer<DeliverySubscriber.DeliveryProcessMessage> = JsonDeserializer(
            DeliverySubscriber.DeliveryProcessMessage::class.java
        )
        return deserializer.apply {
            setRemoveTypeHeaders(false)
            addTrustedPackages("*")
            setUseTypeMapperForKey(true)
        }
    }
}