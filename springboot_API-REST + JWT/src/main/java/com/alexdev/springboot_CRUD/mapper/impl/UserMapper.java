package com.alexdev.springboot_CRUD.mapper.impl;

import com.alexdev.springboot_CRUD.mapper.IUserMapper;
import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.models.Role;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.dto.UserDTO;
import com.alexdev.springboot_CRUD.services.IProfessionService;
import com.alexdev.springboot_CRUD.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class UserMapper implements IUserMapper {
    @Autowired
    IProfessionService professionService;
    @Autowired
    IRoleService roleService;

    @Override
    public User toEntity(UserDTO userDTO) {
        Role role = roleService.getByName(userDTO.getRole())
                .orElseThrow();
        Profession profession = professionService.findByName(userDTO.getProfession())
                .orElseThrow();

        return User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .profession(profession)
                .role(role)
                .build();
    }

    @Override
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .profession(user.getProfession().getName())
                .role(user.getRole().getName())
                .build();
    }
}