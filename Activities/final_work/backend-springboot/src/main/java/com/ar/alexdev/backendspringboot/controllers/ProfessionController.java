package com.ar.alexdev.backendspringboot.controllers;

import com.ar.alexdev.backendspringboot.models.Profession;
import com.ar.alexdev.backendspringboot.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profession")
public class ProfessionController {
    @Autowired
    ProfessionService professionService;

    @GetMapping
    public List<Profession> getAll(){
        return professionService
                .getAll();
    }
}
