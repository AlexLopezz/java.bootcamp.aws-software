package com.ar.alexdev.validatorspringboot.exception;
import lombok.experimental.StandardException;

@StandardException
public class UserWithoutAnyValueException extends RuntimeException {
    public UserWithoutAnyValueException(String message) {
        super(message);
    }
}