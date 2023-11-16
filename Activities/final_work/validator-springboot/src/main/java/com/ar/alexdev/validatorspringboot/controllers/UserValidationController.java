package com.ar.alexdev.validatorspringboot.controllers;

import com.ar.alexdev.validatorspringboot.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate/user")
public class UserValidationController {
    @PostMapping
    public ResponseEntity<?> validateDataUser(@Valid @RequestBody UserDTO userDTO){
        return ResponseEntity
                .ok(userDTO);
    }

}
