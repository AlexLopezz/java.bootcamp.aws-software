package com.alexdev.springboot_CRUD.services;

import com.alexdev.springboot_CRUD.models.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> getAll();
    Optional<UserDTO> getBy(String DNI);
    UserDTO save(UserDTO u);
    void deleteBy(String DNI);
}