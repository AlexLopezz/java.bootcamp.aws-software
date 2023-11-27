package com.ar.alexdev.frontend_springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String dni;

    private String name;

    private String lastName;

    private String dateBirth;

    private String email;

    private String phone;

    private String profession;
}