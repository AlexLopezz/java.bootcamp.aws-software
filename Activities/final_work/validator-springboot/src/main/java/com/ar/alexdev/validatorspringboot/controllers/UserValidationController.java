package com.ar.alexdev.validatorspringboot.controllers;

import com.ar.alexdev.validatorspringboot.dto.UserRequestPost;
import com.ar.alexdev.validatorspringboot.dto.UserRequestPut;
import com.ar.alexdev.validatorspringboot.exception.UserValidateException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/validate/user")
public class UserValidationController {
    @PostMapping
    public ResponseEntity<?> validateDataUserPOST(@Valid @RequestBody UserRequestPost userRequestPost, BindingResult errors){
        Optional.of(errors)
                .filter(Errors::hasErrors)
                .ifPresent(e -> {
                    throw new UserValidateException(errors.getFieldErrors());
                });

        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping
    public ResponseEntity<?> validateDataUserPUT(@Valid @RequestBody UserRequestPut userRequestPut, BindingResult errors){
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
