package com.ar.alexdev.frontend_springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/home", ""})
public class HomeController {
    @GetMapping
    public String homeView(Model model){
        model.addAttribute("headerPage", "Frontend App!");
        model.addAttribute("title", "Welcome to my FrontendApp");
        return "index";
    }
}
