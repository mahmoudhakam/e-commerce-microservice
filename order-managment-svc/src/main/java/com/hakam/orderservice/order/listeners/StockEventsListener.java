package com.hakam.orderservice.order.listeners;

import com.hakam.orderservice.order.OrderService;
import com.hakam.orderservice.order.listeners.events.StockConfirmationEvent;
import com.hakam.orderservice.order.listeners.events.StockRejectionEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.hakam.config.KafkaConfig.ORDER_STOCK_CONFIRM_TOPIC;
import static com.hakam.config.KafkaConfig.ORDER_STOCK_REJECT_TOPIC;
import static com.hakam.orderservice.order.domain.OrderStatus.CANCELLED_OUT_OF_STOCK;
import static com.hakam.orderservice.order.domain.OrderStatus.RESERVED_PROCESSING_PAYMENT;

@Slf4j
@Component
@RequiredArgsConstructor
public class StockEventsListener {

    private final OrderService orderService;

    @KafkaListener(topics = ORDER_STOCK_CONFIRM_TOPIC)
    public void confirmStock(@Payload Object stockConfirmationEvent) {

        var event = (StockConfirmationEvent) stockConfirmationEvent;
        log.info("received stock confirmation event for order {}", event.getOrderId());
        orderService.updateStatus(event.getOrderId(), RESERVED_PROCESSING_PAYMENT)
                .doOnNext(orderService::processPayment)
                .subscribe();
    }

    @KafkaListener(topics = ORDER_STOCK_REJECT_TOPIC)
    public void rejectStock(@Payload Object stockRejectionEvent) {

        var event = (StockRejectionEvent) stockRejectionEvent;
        log.info("received stock rejection event for order {}: {}", event.getOrderId(), event.getMessage());
        orderService.updateStatus(event.getOrderId(), CANCELLED_OUT_OF_STOCK)
                .subscribe();
    }

}
