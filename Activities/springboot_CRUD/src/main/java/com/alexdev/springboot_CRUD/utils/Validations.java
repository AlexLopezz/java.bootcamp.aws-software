package com.alexdev.springboot_CRUD.utils;

import org.springframework.validation.FieldError;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Validations {
    public static Map<String, String> getErrors(List<FieldError> err){
        Map<String, String> errors = new LinkedHashMap<>();
        err.forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));


        return errors;
    }
}
