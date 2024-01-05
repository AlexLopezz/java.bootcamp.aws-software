package com.ar.alexdev.cxfspringbootrs_CRUD.services.impl;

import com.ar.alexdev.cxfspringbootrs_CRUD.mappers.UserMapper;
import com.ar.alexdev.cxfspringbootrs_CRUD.models.DTO.UserDTO;
import com.ar.alexdev.cxfspringbootrs_CRUD.models.User;
import com.ar.alexdev.cxfspringbootrs_CRUD.repositories.UserRepository;
import com.ar.alexdev.cxfspringbootrs_CRUD.services.UserServices;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {
    private final UserRepository repository;
    private final UserMapper userMapper;

    @Autowired
    public UserServicesImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.userMapper = mapper;
    }

    @Override
    public Response getAll() {
        List<UserDTO> users = repository.findAll()
                .stream()
                .map(userMapper::castToDTO).toList();

        return users.isEmpty()? Response.noContent().build() : Response.ok(users).build();
    }

    @Override
    public Response saveUser(UserDTO u) {
        UserDTO userSaved = Optional.ofNullable(u)
                .map(userMapper::castToPOJO)
                .map(repository::save)
                .map(userMapper::castToDTO)
                .orElseThrow();


        return Response.status(201).entity(userSaved).build();
    }

    @Override
    public Response updateUser(UserDTO u) {
        Optional.ofNullable(u)
                .flatMap(dto -> repository.findById(dto.getDni()))
                .ifPresentOrElse(repository::save,
                        () -> { throw new RuntimeException();});

        return Response.ok(u).build();
    }

    @Override
    public Response getUser(String dni) {
        UserDTO userFound = Optional.ofNullable(dni)
                .flatMap(repository::findById)
                .map(userMapper::castToDTO)
                .orElseThrow();

        return Response.ok(userFound).build();
    }
    @Override
    public Response deleteUser(String dni) {
        User userFound = Optional.ofNullable(dni)
                .flatMap(repository::findById)
                .orElseThrow();

        repository.deleteById(userFound.getDni());
        return Response.ok().build();
    }
}