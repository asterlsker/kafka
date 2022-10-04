package com.asterlker.application.order.interfaces

import com.asterlker.application.order.application.OrderFacade
import com.asterlker.application.order.interfaces.dto.OrderDto
import com.asterlker.common.domain.messages.OrderMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/orders")
@RestController
class OrderController(
    private val oderFacade: OrderFacade
) {

    @PostMapping
    fun register(@RequestBody request: OrderMessage) {
        oderFacade.register(request)
    }
}