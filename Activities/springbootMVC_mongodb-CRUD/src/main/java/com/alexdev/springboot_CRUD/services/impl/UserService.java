package com.alexdev.springboot_CRUD.services.impl;

import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.repositories.IUserRepository;
import com.alexdev.springboot_CRUD.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getBy(String DNI) {
        return userRepository.findById(DNI);
    }

    @Override
    public User save(User u) {
        return userRepository.save(u);
    }

    @Override
    public void deleteBy(String DNI) {
        userRepository.deleteById(DNI);
    }
}
