package com.ar.alexdev.validatorspringboot.controllers;

import com.ar.alexdev.validatorspringboot.dto.UserRequestPost;
import com.ar.alexdev.validatorspringboot.dto.UserRequestPut;
import com.ar.alexdev.validatorspringboot.exception.UserValidateException;
import com.ar.alexdev.validatorspringboot.exception.UserWithoutAnyValueException;
import com.ar.alexdev.validatorspringboot.services.UserValidateService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

@RestController
@RequestMapping("/validate/user")
public class UserValidationController {
    @Autowired
    UserValidateService userValidateService;
    @PostMapping
    public ResponseEntity<?> validateDataUserPOST(@Valid @RequestBody UserRequestPost userRequestPost, BindingResult errors){
        userValidateService.checkPost(userRequestPost, errors);

        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping
    public ResponseEntity<?> validateDataUserPUT(@Valid @RequestBody UserRequestPut userRequestPut, BindingResult errors){
        userValidateService.checkPut(userRequestPut, errors);

        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<?> validateExistUser(@PathVariable String dni){
        boolean isValid =  userValidateService.checkUserExist(dni);

        return ResponseEntity.ok().build();
    }
}
