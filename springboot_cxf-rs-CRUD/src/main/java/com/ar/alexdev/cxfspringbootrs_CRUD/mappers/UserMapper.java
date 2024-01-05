package com.ar.alexdev.cxfspringbootrs_CRUD.mappers;

import com.ar.alexdev.cxfspringbootrs_CRUD.models.DTO.UserDTO;
import com.ar.alexdev.cxfspringbootrs_CRUD.models.Profession;
import com.ar.alexdev.cxfspringbootrs_CRUD.models.User;
import com.ar.alexdev.cxfspringbootrs_CRUD.repositories.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDTO> {
    @Autowired
    ProfessionRepository professionRepository;
    @Override
    public UserDTO castToDTO(User user) {
        return UserDTO.builder()
                .dni(user.getDni())
                .name(user.getName())
                .lastName(user.getLastName())
                .dateBirth(user.getDateBirth())
                .profession(user.getProfession().getName())
                .build();
    }

    @Override
    public User castToPOJO(UserDTO userDTO) {
        Profession profession = professionRepository
                .findByName(userDTO.getProfession())
                .stream().findFirst()
                .orElseThrow();

        return User.builder()
                .dni(userDTO.getDni())
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .dateBirth(userDTO.getDateBirth())
                .profession(profession)
                .build();
    }
}
