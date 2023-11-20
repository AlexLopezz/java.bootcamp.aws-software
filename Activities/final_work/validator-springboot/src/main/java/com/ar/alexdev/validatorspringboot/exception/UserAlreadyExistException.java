package com.ar.alexdev.validatorspringboot.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message, String dni) {
        super(String.format(message, dni));
    }
}
