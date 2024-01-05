package com.ar.alexdev.cxfspringbootws_CRUD.services.impl;

import com.ar.alexdev.cxfspringbootws_CRUD.mappers.UserMapper;
import com.ar.alexdev.cxfspringbootws_CRUD.models.DTO.UserDTO;
import com.ar.alexdev.cxfspringbootws_CRUD.models.User;
import com.ar.alexdev.cxfspringbootws_CRUD.repositories.UserRepository;
import com.ar.alexdev.cxfspringbootws_CRUD.services.UserServices;
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
    public List<UserDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(userMapper::castToDTO).toList();
    }

    @Override
    public UserDTO updateUser(UserDTO u) {
         Optional.ofNullable(u)
                .flatMap(dto -> repository.findById(dto.getDni()))
                .ifPresentOrElse(repository::save,
                        () -> { throw new RuntimeException();});

        return u;
    }

    @Override
    public UserDTO getUser(String dni) {
        return Optional.ofNullable(dni)
                .flatMap(repository::findById)
                .map(userMapper::castToDTO)
                .orElseThrow();
    }
    @Override
    public void deleteUser(String dni) {
        User userFound = Optional.ofNullable(dni)
                .flatMap(repository::findById)
                .orElseThrow();

        repository.deleteById(userFound.getDni());
    }

    @Override
    public UserDTO saveUser(UserDTO user) {
        return Optional.ofNullable(user)
                .map(userMapper::castToPOJO)
                .map(repository::save)
                .map(userMapper::castToDTO)
                .orElseThrow();
    }
}