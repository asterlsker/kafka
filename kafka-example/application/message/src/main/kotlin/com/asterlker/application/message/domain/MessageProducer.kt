package com.asterlker.application.message.domain

import com.asterlker.application.message.common.record.PushMessageRecord

interface MessageProducer {

    fun sendMessage(message: PushMessageRecord)
}