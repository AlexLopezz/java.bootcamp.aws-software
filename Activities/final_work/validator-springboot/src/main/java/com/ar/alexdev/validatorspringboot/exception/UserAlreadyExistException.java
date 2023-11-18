package com.ar.alexdev.validatorspringboot.exception;

import org.springframework.beans.factory.annotation.Value;


public class UserAlreadyExistException extends RuntimeException {
    @Value("${user.ALREADY_EXIST}")
    private String message;

    public UserAlreadyExistException(String dni) {
        message = String.format(message, dni);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
