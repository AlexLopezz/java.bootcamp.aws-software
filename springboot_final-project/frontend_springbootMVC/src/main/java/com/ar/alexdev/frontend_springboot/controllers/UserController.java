package com.ar.alexdev.frontend_springboot.controllers;

import com.ar.alexdev.frontend_springboot.model.Profession;
import com.ar.alexdev.frontend_springboot.model.UserDTO;
import com.ar.alexdev.frontend_springboot.services.ProfessionService;
import com.ar.alexdev.frontend_springboot.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ProfessionService professionService;
    @Autowired
    Map<String, Object> cache;

    @GetMapping
    public String listUserView(Model model){
        model.addAttribute("title", "List of users");
        List<UserDTO> u = userService.getUsers();
        model.addAttribute("users", u);

        return "listUser";
    }

    @GetMapping("/form")
    public String formGetUserView(@RequestParam(required = false) String dni, Model model) {
        model.addAttribute("title", "Create user");
        model.addAttribute("user", new UserDTO());

        Optional.ofNullable(dni)
                .flatMap(d -> userService.findBy(d))
                .ifPresent(u -> {
                    cache.put("user", u);
                    model.addAttribute("edit",true);
                    model.addAttribute("title", "Update user");
                    model.addAttribute("user", cache.get("user"));
                });

        return "formUser";
    }

    @PostMapping("/form")
    public String formPostUserView(UserDTO user, Model model) throws JsonProcessingException {
        try {
            userService.save(user);

            return "redirect:/user";

        }catch (HttpClientErrorException e) {
            if(user.getDni() != null)
                if(isUserDniEquals(user.getDni()))
                    model.addAttribute("edit", true);

            model.addAttribute("title", "Error! Check values");
            if(e.getStatusCode() == HttpStatusCode.valueOf(400)) {
                ObjectMapper mapper = new ObjectMapper();
                TypeReference<HashMap<String,Object>> typeRef = new TypeReference<>() {};
                HashMap<String,Object> errors = mapper.readValue(e.getResponseBodyAsString(), typeRef);
                model.addAttribute("errors", errors);
            }
            model.addAttribute("user", user);

            return "formUser";
        }
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam String dni){
        if(isUserDniEquals(dni))
                userService.delete(dni);
        else
            Optional.ofNullable(dni)
                    .ifPresent(d -> userService.delete(d));

        return "redirect:/user";
    }

    @ModelAttribute(name = "professions")
    public List<Profession> professions(){
        return professionService.getAll();
    }
    @ModelAttribute(name = "headerPage")
    public String headerPage(){
        return "List of users - Frontend App";
    }
    @ModelAttribute(name = "errors")
    public Map<String, String> getErrors() {
        return new LinkedHashMap<>();
    }

    @ModelAttribute(name = "edit")
    public boolean editForm(){ return false; }


    private boolean isUserDniEquals(String dni) {
        if (cache.get("user") != null) {
            UserDTO user = (UserDTO) cache.get("user");
            return user.getDni().equals(dni);
        }
        return false;
    }
}