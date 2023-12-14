package com.alexdev.springBoot_CRUD.controller;

import com.alexdev.springBoot_CRUD.model.User;
import com.alexdev.springBoot_CRUD.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService service;

    @GetMapping
    public List<User> getAllUsers(){
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return ResponseEntity.ok(service.save(user));
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "dni") String dni){
        service.delete(dni);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{dni}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "dni") String dni){
        return ResponseEntity.ok(service.getBy(dni));
    }
}
