package com.asterlker.application.message.interfaces

import com.asterlker.common.domain.messages.PushMessage
import com.asterlker.application.message.domain.MessageProducer
import com.asterlker.common.domain.entity.OrderStatus
import com.asterlker.common.domain.messages.OrderMessage
import org.apache.logging.log4j.LogManager
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

private val log = LogManager.getLogger()

@Component
class OrderConsumer(
        private val messageProducer: MessageProducer
) {

    companion object {
        const val SUCCESS_MESSAGE = "배달 기사가 출발하였습니다."
        const val COMPLETE_MESSAGE = "배달이 도착했습니다."
        const val FAILED_MESSAGE = "배달에 실패하였습니다. 자세한 내용은 앱을 확인해주세요."
    }

    @KafkaListener(topics = ["dev.asterisk.order.json"], groupId = "dev.asterisk.order.by.message", containerFactory = "listenerContainerFactory")
    fun bringMessage(@Payload message: OrderMessage) {
        val userId = message.userId
        when (message.orderStatus) {
            OrderStatus.CREATED -> messageProducer.sendMessage(PushMessage(userId, SUCCESS_MESSAGE))
            OrderStatus.COMPLETED -> messageProducer.sendMessage(PushMessage(userId, COMPLETE_MESSAGE))
            OrderStatus.FAILED -> messageProducer.sendMessage(PushMessage(userId, FAILED_MESSAGE))
        }
    }
}