package com.alexdev.springboot_CRUD.controllers;

import com.alexdev.springboot_CRUD.models.dto.UserDTO;
import com.alexdev.springboot_CRUD.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping
    public ResponseEntity<?> getListUsers(){
        List<UserDTO> getAllUsers = userService.getAll();
        int status = getAllUsers.isEmpty()? 204 : 200;

        return ResponseEntity.status(status).body(getAllUsers);
    }
    @GetMapping("/{dni}")
    public ResponseEntity<?> getUserByID(@PathVariable String dni) {
        return ResponseEntity.ok(userService.getBy(dni));
    }
    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody UserDTO user){
        return ResponseEntity.status(201).body(userService.save(user));
    }
    @PutMapping
    public ResponseEntity<?> putUser(@RequestBody UserDTO user){
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> deleteUser(@PathVariable String dni){
        Optional.ofNullable(dni)
                .ifPresent(d -> userService.deleteBy(d));

        return ResponseEntity.ok().build();
    }
}