package com.carbon.warehouseservice.warehouse.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class OrderLine {

    private final String itemId;

    private final Integer quantity;

}
