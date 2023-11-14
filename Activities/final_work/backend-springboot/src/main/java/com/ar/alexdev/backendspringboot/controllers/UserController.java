package com.ar.alexdev.backendspringboot.controllers;

import com.ar.alexdev.backendspringboot.exceptions.MessageResponse;
import com.ar.alexdev.backendspringboot.models.User;
import com.ar.alexdev.backendspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity
                .status(200)
                .body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<?> saveUser(User u){
        Optional<User> userFound=  userService.findBy(u.getDni());
        if(userFound.isPresent())
            return ResponseEntity.status(400)
                    .body(MessageResponse.builder()
                            .message("User with dni ".concat(u.getDni()).concat( "already exist..."))
                    .build()
            );

        return ResponseEntity
                .status(201)
                .body(userService.save(u));
    }

    @PutMapping
    public ResponseEntity<?> updateUser(User u){
        if(userService.findBy(u.getDni()).isPresent())
            return ResponseEntity
                    .ok(userService.save(u));

        return ResponseEntity
                .status(404)
                .body(MessageResponse
                        .builder()
                        .message("User with dni: ".concat(u.getDni()).concat(" not found..."))
                    .build());
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam(name = "dni")String dni){
        if(userService.findBy(dni).isPresent())
            return ResponseEntity
                    .status(200)
                    .body(MessageResponse
                            .builder()
                            .message("User successfully deleted...")
                    .build());

        return ResponseEntity
                .status(404)
                .body(MessageResponse
                        .builder()
                        .message("User with dni: ".concat(dni).concat(" not found..."))
                        .build());
    }

}
