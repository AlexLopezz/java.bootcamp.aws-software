package com.alexdev.springboot_CRUD.controllers;

import com.alexdev.springboot_CRUD.models.dto.AuthRequest;
import com.alexdev.springboot_CRUD.models.dto.AuthResponse;
import com.alexdev.springboot_CRUD.services.impl.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {
    @Autowired
    AuthenticationService service;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Authenticate for get JWT Token",
            responses = {
                    @ApiResponse(description = "Success!", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
                    @ApiResponse(description = "Forbbiden! You must log in with valid token", responseCode = "403"),
            }
    )
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest){
        return service.login(authRequest);
    }
}
