package com.asterlker.application.order.interfaces.dto

import com.asterlker.common.domain.entity.DeliveryStatus

class DeliverySubscriber {

    data class DeliveryProcessMessage(
        val orderId: Long,
        val status: DeliveryStatus
    )
}