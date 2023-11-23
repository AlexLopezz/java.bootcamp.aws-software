package com.ar.alexdev.validatorspringboot.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String dni) {
        super(dni);
    }
}
