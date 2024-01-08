package com.alexdev.springboot_CRUD.controllers;

import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.services.IProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professions")
public class ProfessionController {
    @Autowired
    IProfessionService service;

    @GetMapping
    public ResponseEntity<?> getAllProfessions(){
        List<Profession> professions = service.getAll();
        Optional.of(professions.size())
                .filter(s -> s > 0)
                .orElseThrow(RuntimeException::new);

        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<?> postProfession(@RequestBody Profession profession){
        if(service.existProfession(profession.getId()))
            throw new RuntimeException();

        Profession professionSaved = service.save(profession);
        return ResponseEntity.status(201).body(professionSaved);
    }
    @PutMapping
    public ResponseEntity<?> putProfession(@RequestBody Profession profession){
        if(!service.existProfession(profession.getId()))
            throw new RuntimeException();

        return ResponseEntity.ok(service.save(profession));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if(!service.existProfession(id))
            throw new RuntimeException();

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
