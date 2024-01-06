package com.alexdev.springboot_CRUD.services.impl;

import com.alexdev.springboot_CRUD.mapper.IUserMapper;
import com.alexdev.springboot_CRUD.models.dto.UserDTO;
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
    @Autowired
    IUserMapper mapper;

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream().map(mapper::toDTO).toList();
    }

    @Override
    public Optional<UserDTO> getBy(String DNI) {
        return userRepository.findById(DNI)
                .flatMap(u -> Optional.ofNullable(mapper.toDTO(u)));
    }

    @Override
    public UserDTO save(UserDTO u) {
        return mapper
                .toDTO(userRepository
                        .save(mapper.toEntity(u))
                );
    }

    @Override
    public void deleteBy(String DNI) {
        userRepository.deleteById(DNI);
    }
}
