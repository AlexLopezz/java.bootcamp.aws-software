package com.ar.alexdev.frontend_springboot.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class User {
    private String dni;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Date dateBirth;
    private PROFESSION profession;
}
