package com.asterlker.application.message.interfaces

import com.asterlker.application.message.common.model.OrderStatus
import com.asterlker.application.message.common.record.OrderRecord
import com.asterlker.application.message.common.record.PushMessageRecord
import com.asterlker.application.message.domain.MessageProducer
import org.apache.logging.log4j.LogManager
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import kotlin.math.log

private val log = LogManager.getLogger()

@Component
class OrderConsumer(
        private val messageProducer: MessageProducer
) {

    companion object {
        const val SUCCESS_MESSAGE = "배달 기사가 출발하였습니다."
        const val COMPLETE_MESSAGE = "배달이 도착했습니다."
        const val FAILED_MESSAGE = "배달에 실패하였습니다. 자세한 내용은 앱을 확인해주세요."
        const val NOT_EXISTS_ORDER_STATUS = "# 주문 상태가 존재하지 않습니다."
    }

    @KafkaListener(topics = ["dev.asterisk.order.json"], groupId = "dev.asterisk.order.by.message", containerFactory = "listenerContainerFactory")
    fun bringMessage(@Payload message: OrderRecord) {
        val orderId = message.orderId
        when (message.status) {
            OrderStatus.CREATED -> messageProducer.sendMessage(PushMessageRecord(orderId, SUCCESS_MESSAGE))
            OrderStatus.COMPLETED -> messageProducer.sendMessage(PushMessageRecord(orderId, COMPLETE_MESSAGE))
            OrderStatus.FAILED -> messageProducer.sendMessage(PushMessageRecord(orderId, FAILED_MESSAGE))
            else -> log.error(NOT_EXISTS_ORDER_STATUS)
        }
    }
}