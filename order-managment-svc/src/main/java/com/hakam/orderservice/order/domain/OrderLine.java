package com.hakam.orderservice.order.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.Value;


@Value
@RequiredArgsConstructor
public class OrderLine {

    @NotEmpty
    private final String itemId;

    @Min(1)
    private final Integer quantity;

}
