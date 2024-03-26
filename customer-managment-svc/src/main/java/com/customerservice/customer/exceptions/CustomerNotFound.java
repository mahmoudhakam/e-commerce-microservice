package com.carbon.customerservice.customer.exceptions;

import com.carbon.customerservice.common.exceptions.ServiceApiException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class CustomerNotFound extends ServiceApiException {

    public CustomerNotFound(String customerId) {

        super(NOT_FOUND, String.format("customer with id %s does not exist", customerId));
    }

}
