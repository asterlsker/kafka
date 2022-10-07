package com.asterlker.common.domain.messages

import com.asterlker.common.domain.entity.OrderStatus
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class OrderMessage @JsonCreator constructor(
    @JsonProperty("orderId") val orderId: String,
    @JsonProperty("userId") val userId: String,
    @JsonProperty("orderName") val orderName: String,
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("price") val price: Long,
    @JsonProperty("orderStatus") val orderStatus: OrderStatus,
)