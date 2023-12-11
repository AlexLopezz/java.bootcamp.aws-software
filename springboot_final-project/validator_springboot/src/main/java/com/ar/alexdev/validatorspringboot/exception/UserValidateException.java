package com.ar.alexdev.validatorspringboot.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.util.List;


@Getter @Setter
public class UserValidateException extends RuntimeException {
    List<FieldError> errors;

    public UserValidateException(List<FieldError> errors) {
        this.errors = errors;
    }
}
