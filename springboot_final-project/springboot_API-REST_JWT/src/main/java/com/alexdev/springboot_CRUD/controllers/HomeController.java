package com.alexdev.springboot_CRUD.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@Tag(name = "Home")
public class HomeController {
    @GetMapping
    @Operation(
            summary = "Welcome to my App!",
            responses = {
                    @ApiResponse(description = "Success!", responseCode = "200")
            }
    )
    public String helloRest(){
        return "Welcome to my API-REST!";
    }

}
