package com.asterlker.application.message.domain

import com.asterlker.common.domain.messages.PushMessage

interface MessageProducer {

    fun sendMessage(message: PushMessage)
}