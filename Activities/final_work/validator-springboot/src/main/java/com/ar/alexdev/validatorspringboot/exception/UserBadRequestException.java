package com.ar.alexdev.validatorspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class UserBadRequestException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validationException(MethodArgumentNotValidException m){
        Map<String, String> err = new LinkedHashMap<>();
        m.getBindingResult()
                .getAllErrors()
                .forEach(e -> err.put(((FieldError)e).getField(), e.getDefaultMessage()));

        return err;
    }
}
