package com.alexdev.springboot_CRUD.mapper;

import com.alexdev.springboot_CRUD.models.Form;
import com.alexdev.springboot_CRUD.models.Profession;
import com.alexdev.springboot_CRUD.models.User;
import org.springframework.stereotype.Component;

@Component
public class MapperFormUser {
    public User formToUser(Form form){
        return User.builder()
                .dni(form.getDni())
                .name(form.getName())
                .lastName(form.getLastName())
                .dateBirth(form.getDateBirth())
                .profession(Profession.builder()
                        .id(form.getProfession())
                        .build())
                .build();
    }

    public Form userToForm(User user){
        return Form.builder()
                .dni(user.getDni())
                .name(user.getName())
                .lastName(user.getLastName())
                .dateBirth(user.getDateBirth())
                .profession(user.getProfession().getId())
                .build();
    }
}
