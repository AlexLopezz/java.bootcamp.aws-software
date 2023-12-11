package com.alexdev.springboot_CRUD.services;

import com.alexdev.springboot_CRUD.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    Optional<User> getBy(String DNI);
    void save(User u);
    void deleteBy(String DNI);
}
