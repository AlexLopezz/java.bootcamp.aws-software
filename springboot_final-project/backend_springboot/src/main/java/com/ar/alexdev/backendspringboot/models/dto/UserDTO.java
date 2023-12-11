package com.ar.alexdev.backendspringboot.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@Builder
public class UserDTO {
    private String dni;

    private String name;

    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateBirth;

    private String email;

    private String phone;

    private String profession;
}