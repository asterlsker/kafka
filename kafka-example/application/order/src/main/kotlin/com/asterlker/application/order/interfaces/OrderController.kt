package com.asterlker.application.order.interfaces

import com.asterlker.application.order.application.OrderFacade
import com.asterlker.application.order.interfaces.dto.OrderDto
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
    fun register(@RequestBody request: OrderDto.RegisterRequest) {
        oderFacade.register(request.toMessage())
    }
}