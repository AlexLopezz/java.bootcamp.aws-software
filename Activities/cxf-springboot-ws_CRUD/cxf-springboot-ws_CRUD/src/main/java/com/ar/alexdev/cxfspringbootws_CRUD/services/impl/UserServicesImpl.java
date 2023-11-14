package com.ar.alexdev.cxfspringbootws_CRUD.services.impl;

import com.ar.alexdev.cxfspringbootws_CRUD.models.Profession;
import com.ar.alexdev.cxfspringbootws_CRUD.models.User;
import com.ar.alexdev.cxfspringbootws_CRUD.services.UserServices;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserServicesImpl implements UserServices {
    @Override
    public List<User> getAll() {
        return List.of(
                User.builder()
                        .DNI("43546765")
                        .name("Alex")
                        .lastName("Lopez")
                        .dateBirth(new Date())
                        .profession(
                                Profession.builder()
                                        .id(1L)
                                        .name("Backend Developer")
                                .build()
                        )
                .build(),
                User.builder()
                        .DNI("13546361")
                        .name("Alejandro")
                        .lastName("Sanchez")
                        .dateBirth(new Date())
                        .profession(
                                Profession.builder()
                                        .id(1L)
                                        .name("Frontend Developer")
                                .build()
                        )
                .build(),
                User.builder()
                        .DNI("13546361")
                        .name("Jorge")
                        .lastName("Cambiasso")
                        .dateBirth(new Date())
                        .profession(
                                Profession.builder()
                                        .id(1L)
                                        .name("Fullstack Developer")
                                .build()
                        )
                .build()
        );
    }

    @Override
    public String deleteUser(Long DNI) {
        String message;
        Optional<Long> dni =  Stream.of(DNI)
                .filter(d -> d == 12345678L)
                .findFirst();

        if(dni.isPresent())
            message = "user successfully deleted";
        else
            message = "User with dni ".concat(DNI.toString()).concat(" not exist...");

        return message;
    }

    @Override
    public String saveUser(User u) {
        String message;
        String dni= "123456789";

        message = u.getDNI().equals(dni) ? "This user exist into database..." : "User successfully saved";

        return message;
    }

    @Override
    public String updateUser(User u ) {
        return null;
    }

}
