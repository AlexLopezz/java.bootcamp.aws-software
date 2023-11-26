package com.ar.alexdev.frontend_springboot.controllers;

import com.ar.alexdev.frontend_springboot.dto.PROFESSION;
import com.ar.alexdev.frontend_springboot.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String listUserView(Model model){
        model.addAttribute("title", "List of users");
        model.addAttribute("users", List.of(
                User.builder()
                        .dni("12345678")
                        .name("Alex")
                        .lastName("Lopez")
                        .phone("+43 433 323412")
                        .email("asdas@gmail.com")
                        .dateBirth(new Date())
                        .profession(PROFESSION.BACKEND_DEVELOPER).build(),
                User.builder()
                        .dni("87654321")
                        .name("Axel")
                        .lastName("Alvarez")
                        .phone("+43 433 323412")
                        .email("asdas@gmail.com")
                        .dateBirth(new Date())
                        .profession(PROFESSION.FRONTEND_DEVELOPER).build()
        ));

        return "listUser";
    }


    @ModelAttribute(name = "headerPage")
    public String headerPage(){
        return "List of users - Frontend App";
    }


}
