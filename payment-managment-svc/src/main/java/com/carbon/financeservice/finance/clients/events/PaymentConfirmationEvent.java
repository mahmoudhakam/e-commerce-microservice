package com.carbon.financeservice.finance.clients.events;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class PaymentConfirmationEvent {

    private final String orderId;

}
