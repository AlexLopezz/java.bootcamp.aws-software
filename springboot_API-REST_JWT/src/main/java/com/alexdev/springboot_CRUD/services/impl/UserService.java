package com.alexdev.springboot_CRUD.services.impl;

import com.alexdev.springboot_CRUD.mapper.impl.UserMapper;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.dto.UserRequest;
import com.alexdev.springboot_CRUD.models.dto.UserResponse;
import com.alexdev.springboot_CRUD.repositories.IUserRepository;
import com.alexdev.springboot_CRUD.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository repository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(IUserRepository repository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserResponse> getAll() {
        return repository.findAll().stream()
                .map(userMapper::fromEntityToResponse).toList();
    }

    @Override
    public Optional<UserResponse> findBy(Long id) {
        return repository.findById(id)
                .map(userMapper::fromEntityToResponse);
    }

    @Override
    public UserResponse save(UserRequest u) {
        User usr = userMapper.fromReqToEntity(u);
        return userMapper.fromEntityToResponse(repository.save(usr));
    }

    @Override
    public void deleteBy(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}