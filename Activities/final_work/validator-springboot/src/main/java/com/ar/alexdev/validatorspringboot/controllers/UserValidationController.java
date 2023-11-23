package com.ar.alexdev.validatorspringboot.controllers;

import com.ar.alexdev.validatorspringboot.exception.UserNotFoundException;
import com.ar.alexdev.validatorspringboot.request.MessageRequest;
import com.ar.alexdev.validatorspringboot.request.UserRequestPost;
import com.ar.alexdev.validatorspringboot.request.UserRequestPut;
import com.ar.alexdev.validatorspringboot.services.UserValidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/validate/user")
public class UserValidationController {
    @Autowired
    UserValidateService userValidateService;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void validateDataUserPOST(@Valid @RequestBody UserRequestPost userRequestPost, BindingResult errors){
        userValidateService.checkPost(userRequestPost, errors);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void validateDataUserPUT(@Valid @RequestBody UserRequestPut userRequestPut, BindingResult errors){
        userValidateService.checkPut(userRequestPut, errors);
    }

    @GetMapping("/{dni}")
    @ResponseStatus(HttpStatus.OK)
    public void validateExistUser(@PathVariable String dni){
        Optional.of(userValidateService.checkUserExist(dni))
                    .filter(b -> b)
                    .orElseThrow(() -> new UserNotFoundException(dni));
    }
}
