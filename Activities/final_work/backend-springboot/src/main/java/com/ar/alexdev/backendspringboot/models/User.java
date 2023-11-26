package com.ar.alexdev.backendspringboot.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "db_user")
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
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date dateBirth;

    private String email;

    private String phone;

    @ManyToOne(targetEntity = Profession.class, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "profession_fk")
    private Profession profession;
}