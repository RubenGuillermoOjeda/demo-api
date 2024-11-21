package com.accenture.spring.api.demo_api.exceptions.handler;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.accenture.spring.api.demo_api.exceptions.NoServiceException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NoServiceException.class)
    public ResponseEntity<?> noServiceException(NoServiceException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(ex.getService()  + " " + ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
