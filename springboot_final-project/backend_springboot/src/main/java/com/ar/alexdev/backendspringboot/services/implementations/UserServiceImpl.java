package com.ar.alexdev.backendspringboot.services.implementations;

import com.ar.alexdev.backendspringboot.exception.user.NotFoundException;
import com.ar.alexdev.backendspringboot.models.User;
import com.ar.alexdev.backendspringboot.models.dto.UserDTO;
import com.ar.alexdev.backendspringboot.repositories.UserRepository;
import com.ar.alexdev.backendspringboot.services.UserService;
import com.ar.alexdev.backendspringboot.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper
                .mapToDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO save(UserDTO u) {
        User user = userMapper.mapToEntity(u);
        return userMapper.mapToDTO(userRepository.save(user));
    }

    @Override
    public void delete(String dni) {
        findBy(dni)
                .map(u -> userMapper.mapToEntity(u))
                .ifPresentOrElse(u -> userRepository.delete(u),
                        () -> {
                    throw new NotFoundException(dni);
                });
    }

    @Override
    public Optional<UserDTO> findBy(String dni) {
        return userRepository.findById(dni)
                .map(u -> userMapper.mapToDTO(u));
    }
}
