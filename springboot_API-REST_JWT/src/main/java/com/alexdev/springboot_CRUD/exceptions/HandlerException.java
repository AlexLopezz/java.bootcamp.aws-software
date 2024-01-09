package com.alexdev.springboot_CRUD.exceptions;

import com.alexdev.springboot_CRUD.utils.ErrorExceptionValue;
import com.alexdev.springboot_CRUD.models.dto.MessageErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {
    @Autowired
    ErrorExceptionValue exceptionValue;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundExcepcion.class)
    public MessageErrorResponse notFound(NotFoundExcepcion nf){
        return MessageErrorResponse.builder()
                .errorMessage(String.format(exceptionValue.getNotFound(), nf.getMessage()))
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyExistException.class)
    public MessageErrorResponse alreadyExist(AlreadyExistException ae){
        return MessageErrorResponse.builder()
                .errorMessage(String.format(
                        exceptionValue.getAlreadyExist(), ae.getMessage()))
                .build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(EmptyContentException.class)
    public ResponseEntity<?> emptyExcepcion(EmptyContentException ignored){
        return ResponseEntity.noContent().build();
    }
}
