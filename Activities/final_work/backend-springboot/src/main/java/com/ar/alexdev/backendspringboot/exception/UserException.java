package com.ar.alexdev.backendspringboot.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class UserException extends RuntimeException {
    private final String message;
    private final HttpStatusCode statusCode;

    public UserException(String message, HttpStatusCode statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}