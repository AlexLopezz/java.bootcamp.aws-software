package com.ar.alexdev.backendspringboot.controllers;

import com.ar.alexdev.backendspringboot.models.Profession;
import com.ar.alexdev.backendspringboot.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profession")
public class ProfessionController {
    @Autowired
    ProfessionService professionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Profession save(@RequestBody Profession profession){
        return professionService.save(profession);
    }


    @GetMapping
    public List<Profession> getAll(){
        return professionService
                .getAll();
    }
}
