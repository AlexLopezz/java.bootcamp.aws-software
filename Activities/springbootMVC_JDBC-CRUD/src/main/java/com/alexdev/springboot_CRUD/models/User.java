package com.alexdev.springboot_CRUD.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "db_user")
@Builder
@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String dni;

    private String name;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "profession_fk")
    private Profession profession;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User u)
            return this.getDni().equals(u.getDni());

        return false;
    }
}