package com.alexdev.springboot_CRUD.controllers;

import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.services.IProfessionService;
import com.alexdev.springboot_CRUD.services.IUserService;
import com.alexdev.springboot_CRUD.utils.Validations;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    IProfessionService professionService;

    @GetMapping
    public String getListUsers(Model model){
        model.addAttribute("title", "List of Users!");
        model.addAttribute("users", userService.getAll());

        return "list";
    }

    @GetMapping("/form")
    public String formGetUserView(@RequestParam(required = false) String dni, Model model) {
        model.addAttribute("title", "Create user");
        model.addAttribute("user", new User());

        Optional.ofNullable(dni)
                .flatMap(d -> userService.getBy(d))
                .ifPresent(u -> {
                    model.addAttribute("edit",true);
                    model.addAttribute("title", "Update user");
                    model.addAttribute("user", u);
                });

        return "form";
    }

    @PostMapping("/form")
    public String postFormUser(@Valid User user, BindingResult validations, Model model){
        if(validations.hasErrors()){
            model.addAttribute("title", "Error! Check values");

            Map<String, String> errors = Validations.getErrors(validations.getFieldErrors());
            model.addAttribute("errors", errors);

            return "form";
        }
        Optional.of(user)
                .ifPresent(u -> userService.save(u));


        return "redirect:/user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam String dni, Model model){
        Optional.ofNullable(dni)
                .ifPresent(d -> userService.deleteBy(d));

        return "redirect:/user";
    }



    @ModelAttribute(name = "title")
    public String getTitle(){
        return "Title Custom";
    }
    @ModelAttribute(name = "professions")
    public List<Profession> getProfessions(){
        return professionService.getAll();
    }
    @ModelAttribute(name = "edit")
    public boolean editForm(){ return false; }
    @ModelAttribute(name = "errors")
    public Map<String, String> getErrors(){
        return new LinkedHashMap<>();
    }
}
