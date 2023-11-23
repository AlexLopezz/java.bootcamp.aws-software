package com.ar.alexdev.validatorspringboot.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String dni) {
        super(dni);
    }
}
