package com.ar.alexdev.backendspringboot.controllers;

import com.ar.alexdev.backendspringboot.exception.UserException;
import com.ar.alexdev.backendspringboot.models.User;
import com.ar.alexdev.backendspringboot.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Operation(summary = "Fetch all users from database!", tags = "User endpoints")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of users in database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "204", description = "OK! but no users in database"),
            @ApiResponse(responseCode = "500", description = "Internal error from api."),
    })
    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.getAllUsers();

        if(users.isEmpty())
            return ResponseEntity.status(204).build();

        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Save a database user!", tags = "User endpoints")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully saved.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "User exist into database.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal error from api."),
    })
    @PostMapping
    public ResponseEntity<?> saveUser(User user){
        userService.findBy(user.getDni())
                .ifPresent(u ->{
                    throw new UserException(
                            "User with dni: ".concat(user.getDni()).concat(" already exist into database."),
                            HttpStatusCode.valueOf(400));
                });

        return ResponseEntity
                .status(201)
                .body(userService.save(user));
    }

    @Operation(summary = "Update a database user!", tags = "User endpoints")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User succesfully updated", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User not found in database", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal error from api."),
    })
    @PutMapping
    public ResponseEntity<?> updateUser(User user){
        if(userService.findBy(user.getDni()).isPresent())
            return ResponseEntity
                    .ok(userService.save(user));
        else
            throw new UserException(
                    "User with dni: ".concat(user.getDni()).concat(" not found..."),
                    HttpStatusCode.valueOf(404)
            );
    }

    @Operation(summary = "Delete a database user!", tags = "User endpoints")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User succesfully deleted.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User not found to remove from database.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal error from api."),
    })
    @DeleteMapping("/{dni}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "dni") String dni){
        if(userService.findBy(dni).isPresent())
            return ResponseEntity
                    .status(200)
                    .body("User successfully deleted...");
        else
            throw new UserException(
                    "User with dni: ".concat(dni).concat(" not found..."),
                    HttpStatusCode.valueOf(404)
            );
    }
    @GetMapping("/{dni}")
    public ResponseEntity<?> getUser(@PathVariable String dni){
        User u = userService.findBy(dni)
                .orElseThrow(() -> new UserException("User with dni ".concat(dni).concat(" not found"), HttpStatusCode.valueOf(404)));

        return ResponseEntity.ok(u);
    }
}