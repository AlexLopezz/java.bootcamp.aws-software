package com.ar.alexdev.backendspringboot.services;

import com.ar.alexdev.backendspringboot.models.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO save(UserDTO u);
    void delete(String dni);
    Optional<UserDTO> findBy(String dni);
}
