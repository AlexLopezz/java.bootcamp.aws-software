package com.ar.alexdev.backendspringboot.services;

import com.ar.alexdev.backendspringboot.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User save(User u);
    boolean delete(String dni);
    Optional<User> findBy(String dni);
}
