package com.ar.alexdev.frontend_springboot.controllers;

import com.ar.alexdev.frontend_springboot.model.PROFESSION;
import com.ar.alexdev.frontend_springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/form")
    public String formGetUserView(@RequestParam(required = false) String dni, Model model) {
        model.addAttribute("title", "Create user");
        model.addAttribute("user", new User());

        /*
        Optional.ofNullable(dni)
                .flatMap(d -> userService.searchByDNI(d))
                .ifPresent(u -> {
                    model.addAttribute("title", "Update user");
                    model.addAttribute("user", u);
                }); */

        return "formUser";
    }

    @PostMapping("/form")
    public String formPostUserView(@RequestBody User user, Model model) {

        /*
        Optional.ofNullable(dni)
                .flatMap(d -> userService.searchByDNI(d))
                .ifPresent(u -> {
                    model.addAttribute("title", "Update user");
                    model.addAttribute("user", u);
                }); */

        return "listUser";
    }





    @ModelAttribute(name = "professions")
    public PROFESSION[] professions(){
        return PROFESSION.values();
    }
    @ModelAttribute(name = "headerPage")
    public String headerPage(){
        return "List of users - Frontend App";
    }


}
