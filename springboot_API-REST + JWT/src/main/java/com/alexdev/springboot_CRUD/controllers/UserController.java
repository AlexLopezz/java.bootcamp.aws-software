package com.alexdev.springboot_CRUD.controllers;

import com.alexdev.springboot_CRUD.exceptions.AlreadyExistException;
import com.alexdev.springboot_CRUD.exceptions.EmptyContentException;
import com.alexdev.springboot_CRUD.exceptions.NotFoundExcepcion;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.dto.UserRequest;
import com.alexdev.springboot_CRUD.models.dto.UserResponse;
import com.alexdev.springboot_CRUD.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getListUsers(){
        List<UserResponse> users = service.getAll();
        Optional.of(users.size()).filter(s -> s > 0)
                .orElseThrow(EmptyContentException::new);

        return users;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse postUser(@RequestBody UserRequest user){
        service.findByUsername(user.getUsername())
                .ifPresent(p -> { throw new AlreadyExistException(p.getClass().getSimpleName()); });

        return service.save(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserResponse putUser(@RequestBody UserRequest user){
        if(service.findBy(user.getId()).isEmpty())
            throw new NotFoundExcepcion(User.class.getSimpleName());

        return service.save(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserByID(@PathVariable Long id) {
        return service.findBy(id)
                .orElseThrow(() -> new NotFoundExcepcion(User.class.getSimpleName()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        if(service.findBy(id).isEmpty())
            throw new NotFoundExcepcion(User.class.getSimpleName());

        service.deleteBy(id);
    }
}