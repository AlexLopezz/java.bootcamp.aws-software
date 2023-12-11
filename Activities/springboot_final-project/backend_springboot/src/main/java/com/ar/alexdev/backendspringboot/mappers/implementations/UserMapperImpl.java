package com.ar.alexdev.backendspringboot.mappers.implementations;

import com.ar.alexdev.backendspringboot.mappers.UserMapper;
import com.ar.alexdev.backendspringboot.models.Profession;
import com.ar.alexdev.backendspringboot.models.User;
import com.ar.alexdev.backendspringboot.models.dto.UserDTO;
import com.ar.alexdev.backendspringboot.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Autowired
    ProfessionService professionService;


    public UserDTO mapToDTO(User user){
        return UserDTO.builder()
                    .dni(user.getDni())
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .dateBirth(user.getDateBirth())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .profession(user.getProfession().getName())
                .build();
    }

    public List<UserDTO> mapToDTOs(List<User> users){
        return users.stream()
                .map(this::mapToDTO)
                .toList();
    }
    public List<User> mapToEntities(List<UserDTO> users){
        return users.stream()
                .map(this::mapToEntity)
                .toList();
    }

    public User mapToEntity(UserDTO user){
        Profession profession = professionService
                .findByName(user.getProfession())
                .orElse(null);

        return User.builder()
                    .dni(user.getDni())
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .dateBirth(user.getDateBirth())
                    .phone(user.getPhone())
                    .email(user.getEmail())
                    .profession(profession)
                .build();
    }
}
