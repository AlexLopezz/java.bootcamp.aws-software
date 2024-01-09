package com.alexdev.springboot_CRUD.controllers;

import com.alexdev.springboot_CRUD.exceptions.AlreadyExistException;
import com.alexdev.springboot_CRUD.exceptions.EmptyContentException;
import com.alexdev.springboot_CRUD.exceptions.NotFoundExcepcion;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.dto.UserRequest;
import com.alexdev.springboot_CRUD.models.dto.UserResponse;
import com.alexdev.springboot_CRUD.services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Users")
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Get all users in database.",
            responses = {
                    @ApiResponse(description = "All ok!", responseCode = "200"),
                    @ApiResponse(description = "All ok, but no content!", responseCode = "204"),
                    @ApiResponse(description = "Forbbiden! You must log in with valid token", responseCode = "403"),
            }
    )
    public List<UserResponse> getListUsers(){
        List<UserResponse> users = service.getAll();
        Optional.of(users.size()).filter(s -> s > 0)
                .orElseThrow(EmptyContentException::new);

        return users;
    }

    @PostMapping
    @PreAuthorize("hasRole('Administrator')")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create a new user in database.",
            responses = {
                    @ApiResponse(description = "Success!", responseCode = "201"),
                    @ApiResponse(description = "User existing in database.", responseCode = "409"),
                    @ApiResponse(description = "Forbbiden! You must log in with valid token", responseCode = "403"),
            }
    )
    public UserResponse postUser(@RequestBody UserRequest user){
        service.findByUsername(user.getUsername())
                .ifPresent(p -> { throw new AlreadyExistException(p.getClass().getSimpleName()); });

        return service.save(user);
    }

    @PutMapping
    @PreAuthorize("hasRole('Administrator')")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Update existing user in database.",
            responses = {
                    @ApiResponse(description = "Success!", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
                    @ApiResponse(description = "Forbbiden! You must log in with valid token", responseCode = "403"),
            }
    )
    public UserResponse putUser(@RequestBody UserRequest user){
        if(service.findBy(user.getId()).isEmpty())
            throw new NotFoundExcepcion(User.class.getSimpleName());

        return service.save(user);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('Administrator', 'Employee')")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Get existing user.",
            responses = {
                    @ApiResponse(description = "Success!", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
                    @ApiResponse(description = "Forbbiden! You must log in with valid token", responseCode = "403"),
            }
    )
    public UserResponse getUserByID(@PathVariable Long id) {
        return service.findBy(id)
                .orElseThrow(() -> new NotFoundExcepcion(User.class.getSimpleName()));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('Administrator')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delet existing user.",
            responses = {
                    @ApiResponse(description = "Success!", responseCode = "204"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
                    @ApiResponse(description = "Forbbiden! You must log in with valid token", responseCode = "403"),
            }
    )
    public void deleteUser(@PathVariable Long id){
        if(service.findBy(id).isEmpty())
            throw new NotFoundExcepcion(User.class.getSimpleName());

        service.deleteBy(id);
    }
}