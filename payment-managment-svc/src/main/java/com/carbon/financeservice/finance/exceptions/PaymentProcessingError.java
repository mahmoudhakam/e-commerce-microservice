package com.carbon.financeservice.finance.exceptions;

public class PaymentProcessingError extends RuntimeException {

    public PaymentProcessingError(String orderId) {

        super(String.format("error processing payment for order %s", orderId));
    }

}
