package com.ar.alexdev.backendspringboot.controllers;

import com.ar.alexdev.backendspringboot.exception.user.AlreadyExistException;
import com.ar.alexdev.backendspringboot.exception.user.NoContentException;
import com.ar.alexdev.backendspringboot.exception.user.NotFoundException;
import com.ar.alexdev.backendspringboot.models.dto.UserDTO;
import com.ar.alexdev.backendspringboot.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @Operation(summary = "Fetch all users from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All OK!", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "204", description = "Everything went well! But there is no content!"),
            @ApiResponse(responseCode = "500", description = "API Internal Error."),
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDTO> getAllUsers(){
        return Optional.of(userService.getAllUsers())
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoContentException::new);
    }

    @Operation(summary = "Save a database user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully saved.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "409", description = "User already exist.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "API Internal Error."),
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO user){
        userService.findBy(user.getDni())
                .ifPresent(u ->{ throw new AlreadyExistException(user.getDni()); });

        return userService.save(user);
    }

    @Operation(summary = "Update a database user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All OK!", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User not found.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "API Internal Error."),
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public void updateUser(@RequestBody UserDTO user){
        userService.findBy(user.getDni())
                .ifPresentOrElse(u -> userService.save(u),
                        () -> { throw new NotFoundException(user.getDni()); });
    }

    @Operation(summary = "Delete a database user!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All OK!", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "API Internal Error."),
    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{dni}")
    public void deleteUser(@PathVariable(name = "dni") String dni){
        userService.delete(dni);
    }

    @Operation(summary = "Get user by dni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All OK!", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "User not found."),
            @ApiResponse(responseCode = "500", description = "API Internal Error."),
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{dni}")
    public UserDTO getUser(@PathVariable String dni){
        return userService.findBy(dni)
                .orElseThrow(() -> new NotFoundException(dni));
    }
}