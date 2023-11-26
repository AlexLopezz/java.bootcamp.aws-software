package com.ar.alexdev.frontend_springboot.controllers;

import com.ar.alexdev.frontend_springboot.model.PROFESSION;
import com.ar.alexdev.frontend_springboot.model.User;
import com.ar.alexdev.frontend_springboot.services.UserService;
import com.ar.alexdev.frontend_springboot.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String listUserView(Model model){
        model.addAttribute("title", "List of users");
         List<User> u = userService.getUsers();
        model.addAttribute("users", u);

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
        try {
            userService.save(user);

        }catch (HttpClientErrorException e){
            model.addAttribute("title", "Error! Check field values!");
            model.addAttribute("errors", Validator.getErrors(e.getResponseBodyAsString()));

            return "formUser";
        }

        return "redirect:/user";
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