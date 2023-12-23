package com.alexdev.springboot_CRUD.mapper.impl;

import com.alexdev.springboot_CRUD.mapper.IUserMapper;
import com.alexdev.springboot_CRUD.mapper.Mapper;
import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.dto.UserDTO;
import com.alexdev.springboot_CRUD.services.IProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper implements IUserMapper {
    @Autowired
    IProfessionService professionService;

    @Override
    public User toEntity(UserDTO userDTO) {
        Profession profession = professionService.findByName(userDTO.getProfession())
                .orElseThrow();
        return User.builder()
                .dni(userDTO.getDni())
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .dateBirth(userDTO.getDateBirth())
                .profession(profession)
                .build();
    }

    @Override
    public List<User> toEntities(List<UserDTO> userDTOS) {
        return userDTOS.stream()
                .map(this::toEntity)
                .toList();
    }

    @Override
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .dni(user.getDni())
                .name(user.getName())
                .lastName(user.getLastName())
                .dateBirth(user.getDateBirth())
                .profession(user.getProfession().getName())
                .build();
    }

    @Override
    public List<UserDTO> toDTOs(List<User> users) {
        return users.stream()
                .map(this::toDTO)
                .toList();
    }
}
