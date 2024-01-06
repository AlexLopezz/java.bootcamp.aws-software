package com.alexdev.springboot_CRUD.services.impl;

import com.alexdev.springboot_CRUD.models.Role;
import com.alexdev.springboot_CRUD.repositories.IRoleRepository;
import com.alexdev.springboot_CRUD.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository repository;


    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Role> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Role> getByName(String name) {
        return repository.findByName(name);
    }
}
