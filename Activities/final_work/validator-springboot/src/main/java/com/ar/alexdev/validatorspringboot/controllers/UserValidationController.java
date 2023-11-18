package com.ar.alexdev.validatorspringboot.controllers;

import com.ar.alexdev.validatorspringboot.dto.UserRequestPost;
import com.ar.alexdev.validatorspringboot.exception.UserValidateException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/validate/user")
public class UserValidationController {
    @PostMapping
    public ResponseEntity<?> validateDataUser(@Valid @RequestBody UserRequestPost userRequestPost, BindingResult errors){
        Optional.of(errors)
                .filter(Errors::hasErrors)
                .ifPresent(e -> {
                    throw new UserValidateException(errors.getFieldErrors());
                });

        return ResponseEntity
                .ok()
                .build();
    }
}
