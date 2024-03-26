package com.hakam.orderservice.order.controllers;

import com.hakam.orderservice.order.OrderService;
import com.hakam.orderservice.order.controllers.models.CreateOrderRequest;
import com.hakam.orderservice.order.controllers.models.CreateOrderResponse;
import com.hakam.orderservice.order.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(CREATED)
    @PostMapping
    public Mono<CreateOrderResponse> initiate(@Validated @RequestBody CreateOrderRequest request) {

        log.info("initiate order request from customer {}", request.getCustomerId());
        return orderService.create(request.toOrder())
                .doOnNext(orderService::reserveStock)
                .map(Order::getId)
                .map(CreateOrderResponse::new);
    }

}
