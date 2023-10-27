package com.alexdev.springboot_CRUD.repositories;

import com.alexdev.springboot_CRUD.models.User;

import java.util.Optional;

public interface IUserRepository extends IRepository<User> {
    Optional<User> getUserBy(String dni);
    void deleteBy(String dni);
}
