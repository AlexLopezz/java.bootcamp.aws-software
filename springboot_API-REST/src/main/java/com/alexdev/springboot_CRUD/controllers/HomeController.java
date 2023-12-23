package com.alexdev.springboot_CRUD.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/", "/home"})
public class HomeController {
    @GetMapping
    public String helloRest(){
        return "Welcome to my API-REST!";
    }

}
