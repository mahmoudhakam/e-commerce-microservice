package com.carbon.catalogueservice.product.exceptions;

import com.carbon.catalogueservice.common.exceptions.ServiceApiException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ItemNotFound extends ServiceApiException {

    public ItemNotFound(String itemId) {

        super(NOT_FOUND, String.format("item with id %s does not exist", itemId));
    }

}
