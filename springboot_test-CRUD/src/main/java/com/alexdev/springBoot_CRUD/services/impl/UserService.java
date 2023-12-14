package com.alexdev.springBoot_CRUD.services.impl;

import com.alexdev.springBoot_CRUD.model.User;
import com.alexdev.springBoot_CRUD.repository.IUserRepository;
import com.alexdev.springBoot_CRUD.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> getBy(String dni) {
        return repository.findById(dni);
    }

    @Override
    public void delete(String dni) {
        repository.deleteById(dni);
    }
}