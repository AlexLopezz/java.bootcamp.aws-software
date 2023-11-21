package com.ar.alexdev.backendspringboot.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "db_user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class User {
    @Id
    private String dni;

    private String name;

    private String lastName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern= "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date dateBirth;

    private String email;

    private String phone;

    private PROFESSION profession;
}
