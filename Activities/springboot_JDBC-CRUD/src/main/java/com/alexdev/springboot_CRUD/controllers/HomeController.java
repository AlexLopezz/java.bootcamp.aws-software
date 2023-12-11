package com.alexdev.springboot_CRUD.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    @GetMapping
    public String helloView(Model model){
        model.addAttribute("headerPage", "Home Page");
        model.addAttribute("title", "Welcome to my SpringBoot App JDBC CRUD!");

        return "index";
    }

}
