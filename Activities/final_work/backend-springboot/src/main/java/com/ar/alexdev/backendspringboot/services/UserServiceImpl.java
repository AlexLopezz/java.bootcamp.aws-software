package com.ar.alexdev.backendspringboot.services;

import com.ar.alexdev.backendspringboot.models.User;
import com.ar.alexdev.backendspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User u) {
        return userRepository.save(u);
    }

    @Override
    public boolean delete(String dni) {
        Optional<User> user = findBy(dni);
        user.ifPresent(u -> userRepository.delete(u));

        return user.isPresent();
    }

    @Override
    public Optional<User> findBy(String dni) {
        return userRepository.findById(dni);
    }
}
