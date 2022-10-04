package com.asterlker.application.delivery.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter

import org.springframework.kafka.support.converter.JsonMessageConverter




@Configuration
class JsonMessageConverterConfig {
    @Bean
    fun jsonMessageConverter(): JsonMessageConverter? {
        return ByteArrayJsonMessageConverter()
    }
}