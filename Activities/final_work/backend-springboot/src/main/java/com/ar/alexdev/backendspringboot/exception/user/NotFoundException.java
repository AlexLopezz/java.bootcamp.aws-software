package com.ar.alexdev.backendspringboot.exception.user;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class NotFoundException extends RuntimeException {
    public NotFoundException(String dni) {
        super(dni);
    }
}