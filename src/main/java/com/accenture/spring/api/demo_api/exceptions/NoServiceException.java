package com.accenture.spring.api.demo_api.exceptions;

import lombok.Getter;
import lombok.Setter;

public class NoServiceException extends RuntimeException {

    public NoServiceException(String message, String service) {
        super(message);
        this.service = service;
    }

    @Getter
    @Setter
    private String service;

}
