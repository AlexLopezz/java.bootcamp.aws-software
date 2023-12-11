package com.ar.alexdev.validatorspringboot.controllers;

import com.ar.alexdev.validatorspringboot.exception.UserNotFoundException;
import com.ar.alexdev.validatorspringboot.request.MessageRequest;
import com.ar.alexdev.validatorspringboot.request.UserRequestPost;
import com.ar.alexdev.validatorspringboot.request.UserRequestPut;
import com.ar.alexdev.validatorspringboot.services.UserValidateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Validate the data using the POST method, to make a record.", tags = "User validations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everything went as expected", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Occurs when a field does not comply with validation.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "409", description = "It happens when everything went well, but there is a conflict. Generally when the user already exists", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error. In this case... Occurs when you want to consume an external server and it does not respond.", content = @Content(mediaType = "application/json"))
    })
    public void validateDataUserPOST(@Valid @RequestBody UserRequestPost userRequestPost, BindingResult errors){
        userValidateService.checkPost(userRequestPost, errors);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Validate the data using the PUT method, to make a modification to an existing user.", tags = "User validations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everything went as expected", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Occurs when a field does not comply with validation.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Occurs when a user is not found, therefore it cannot be modified.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error. In this case... Occurs when this service, want to consume an external server and it does not respond.", content = @Content(mediaType = "application/json"))
    })
    public void validateDataUserPUT(@Valid @RequestBody UserRequestPut userRequestPut, BindingResult errors){
        userValidateService.checkPut(userRequestPut, errors);
    }


    @GetMapping("/{dni}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Validate if user exist by DNI", tags = "User validations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everything went as expected", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Occurs when a user is not found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal server error. In this case... Occurs when this service, want to consume an external server and it does not respond.", content = @Content(mediaType = "application/json"))
    })
    public void validateExistUser(@PathVariable String dni){
        Optional.of(userValidateService.checkUserExist(dni))
                    .filter(b -> b)
                    .orElseThrow(() -> new UserNotFoundException(dni));
    }
}
