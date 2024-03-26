package com.carbon.warehouseservice.warehouse.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.Instant;
import java.util.List;

@Value
@Builder
@RequiredArgsConstructor
public class Order {

    private final String id;

    private final String customerId;

    private final List<OrderLine> orderLines;

    private final Address shippingAddress;

    public Shipment toShipment() {

        return Shipment.builder()
                .orderId(id)
                .customerId(customerId)
                .shippingAddress(shippingAddress)
                .dateCreated(Instant.now())
                .build();
    }

}
