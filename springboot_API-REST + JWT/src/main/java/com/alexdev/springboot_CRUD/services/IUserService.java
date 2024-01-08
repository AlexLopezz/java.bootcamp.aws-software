package com.alexdev.springboot_CRUD.services;

import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.dto.UserRequest;
import com.alexdev.springboot_CRUD.models.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserResponse> getAll();
    Optional<UserResponse> findBy(Long id);
    UserResponse save(UserRequest u);
    void deleteBy(Long id);
    Optional<User> findByUsername(String username);
}