package com.alexdev.springboot_CRUD.controllers;

import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.enums.PROFESSION;
import com.alexdev.springboot_CRUD.services.IUserService;
import com.alexdev.springboot_CRUD.utils.Validations;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping
    public String getListUsers(Model model){
        model.addAttribute("title", "List of Users!");
        model.addAttribute("users", userService.getAll());

        return "list";
    }

    @GetMapping("/form")
    public String formUser(@ModelAttribute User user, Model model){
        model.addAttribute("title", "Create user");

        Optional.ofNullable(user.getDni())
                        .flatMap(d -> userService.searchByDNI(d))
                                .ifPresent(u -> {
                                    model.addAttribute("user", u);
                                    model.addAttribute("title", "Update user");
                                });

        model.addAttribute("professions", PROFESSION.values());

        return "form";
    }

    @PostMapping("/form")
    public String postFormUser(@Valid User user, BindingResult validations, Model model){
        if(validations.hasErrors()){
           Map<String, String> errors = Validations.getErrors(validations.getFieldErrors());
           model.addAttribute("errors", errors);

           return "form";
        }

        Optional.ofNullable(user)
                .ifPresent(u -> userService.save(u));


        return "redirect:/user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam String id, Model model){
        Optional.ofNullable(id)
                .ifPresent(d -> userService.deleteBy(d));

        return "redirect:/user";
    }
}
