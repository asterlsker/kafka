package com.asterlker.application.message.domain.message

interface MessageProducer {

    fun sendMessage(message: String)
}