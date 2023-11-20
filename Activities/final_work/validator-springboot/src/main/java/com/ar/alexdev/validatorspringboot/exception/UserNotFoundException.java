package com.ar.alexdev.validatorspringboot.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message, String dni) {
        super(String.format(message, dni));
    }
}
