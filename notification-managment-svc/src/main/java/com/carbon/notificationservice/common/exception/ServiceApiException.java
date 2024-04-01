package com.carbon.notificationservice.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class ServiceApiException extends RuntimeException {

    private final HttpStatusCode httpStatus;

    public ServiceApiException(HttpStatusCode httpStatus, String message) {

        super(message);
        this.httpStatus = httpStatus;
    }

}
