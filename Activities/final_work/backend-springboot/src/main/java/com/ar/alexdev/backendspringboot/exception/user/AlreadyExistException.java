package com.ar.alexdev.backendspringboot.exception.user;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String dni) {
        super(dni);
    }
}
