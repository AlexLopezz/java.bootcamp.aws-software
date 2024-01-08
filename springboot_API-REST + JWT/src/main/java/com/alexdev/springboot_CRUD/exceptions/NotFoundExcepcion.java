package com.alexdev.springboot_CRUD.exceptions;
import lombok.Getter;

@Getter
public class NotFoundExcepcion extends RuntimeException {
    public NotFoundExcepcion(String model) {
        super(model);
    }
}