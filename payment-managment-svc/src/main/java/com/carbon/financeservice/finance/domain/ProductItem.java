package com.carbon.financeservice.finance.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

@Value
@RequiredArgsConstructor
public class ProductItem {

    private final String id;

    private final BigDecimal price;

    private final String name;

    private final String description;

}
