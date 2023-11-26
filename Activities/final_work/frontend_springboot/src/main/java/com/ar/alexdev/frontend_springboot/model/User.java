package com.ar.alexdev.frontend_springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date dateBirth;
    private PROFESSION profession;
}
