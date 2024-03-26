package com.carbon.financeservice.finance.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

@Value
@RequiredArgsConstructor
public class InvoiceLine {

    private final String itemId;

    private final String fullItemDescription;

    private final Integer quantity;

    private final BigDecimal price;

    public InvoiceLine(ProductItem item, int quantity) {

        this.itemId = item.getId();
        this.fullItemDescription = String.format("%s - %s", item.getName(), item.getDescription());
        this.quantity = quantity;
        this.price = item.getPrice();
    }

}
