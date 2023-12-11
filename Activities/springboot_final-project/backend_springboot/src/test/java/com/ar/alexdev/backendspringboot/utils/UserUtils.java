package com.ar.alexdev.backendspringboot.utils;

import com.ar.alexdev.backendspringboot.models.dto.UserDTO;

import java.util.Date;

public class UserUtils {
    public static UserDTO userBuildDefault(){
        return UserDTO.builder()
                .name("Alex")
                .lastName("Lopez")
                .dni("45657665")
                .phone("+54 3454 334455")
                .email("asda@gmail.com")
                .dateBirth(new Date())
                .profession("Backend Developer")
                .build();
    }
}
