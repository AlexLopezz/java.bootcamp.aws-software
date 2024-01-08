package com.alexdev.springboot_CRUD.exceptions;

import lombok.Getter;

@Getter
public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String model) {
        super(model);
    }
}