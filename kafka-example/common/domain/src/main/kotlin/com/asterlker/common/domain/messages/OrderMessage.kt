package com.asterlker.common.domain.messages

import com.asterlker.common.domain.entity.OrderStatus
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class OrderMessage @JsonCreator constructor(
    @JsonProperty("userId") val userId: String,
    @JsonProperty("orderName") val orderName: String,
    @JsonProperty("quantity") val quantity: String,
    @JsonProperty("price") val price: String,
)