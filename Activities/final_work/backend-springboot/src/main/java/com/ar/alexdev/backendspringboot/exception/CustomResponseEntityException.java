package com.ar.alexdev.backendspringboot.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserException.class)
    public final ResponseEntity<ExceptionResponse> handlerException(UserException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                ex.getStatusCode().value(), ex.getStatusCode().toString());

        return new ResponseEntity<>(exceptionResponse, ex.getStatusCode());
    }
}