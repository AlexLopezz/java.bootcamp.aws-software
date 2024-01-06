package com.alexdev.springboot_CRUD.services;

import com.alexdev.springboot_CRUD.models.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> getAll();
    Role save(Role role);
    void deleteById(Long id);
    Optional<Role> getById(Long id);
    Optional<Role> getByName(String name);
}
