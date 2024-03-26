package com.hakam.orderservice.order.listeners.events;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class StockConfirmationEvent {

    private final String orderId;

}
