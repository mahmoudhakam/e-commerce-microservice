package com.hakam.orderservice.order.listeners;

import com.hakam.orderservice.order.OrderService;
import com.hakam.orderservice.order.listeners.events.PaymentConfirmationEvent;
import com.hakam.orderservice.order.listeners.events.PaymentRejectionEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.hakam.config.KafkaConfig.ORDER_PAYMENT_CONFIRM_TOPIC;
import static com.hakam.config.KafkaConfig.ORDER_PAYMENT_REJECT_TOPIC;
import static com.hakam.orderservice.order.domain.OrderStatus.CANCELLED_PAYMENT_REJECTED;
import static com.hakam.orderservice.order.domain.OrderStatus.PAYED_PREPARING_FOR_SHIPMENT;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentEventsListener {

    private final OrderService orderService;

    @KafkaListener(topics = ORDER_PAYMENT_CONFIRM_TOPIC)
    public void confirmPayment(@Payload Object paymentConfirmationEvent) {

        var event = (PaymentConfirmationEvent) paymentConfirmationEvent;
        log.info("received payment confirmation event for order {}", event.getOrderId());
        orderService.updateStatus(event.getOrderId(), PAYED_PREPARING_FOR_SHIPMENT)
                .doOnNext(orderService::dispatch)
                .subscribe();
    }

    @KafkaListener(topics = ORDER_PAYMENT_REJECT_TOPIC)
    public void rejectPayment(@Payload Object paymentRejectionEvent) {

        var event = (PaymentRejectionEvent) paymentRejectionEvent;
        log.info("received payment rejection event for order {}: {}", event.getOrderId(), event.getMessage());
        orderService.updateStatus(event.getOrderId(), CANCELLED_PAYMENT_REJECTED)
                .doOnNext(orderService::releaseStock)
                .subscribe();
    }

}
