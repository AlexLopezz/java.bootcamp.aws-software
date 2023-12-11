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
        return userRepository.getAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public Optional<User> searchByDNI(String dni) {
        return userRepository.getUserBy(dni);
    }

    @Override
    public void deleteBy(String dni) {
        userRepository.deleteBy(dni);
    }
}
