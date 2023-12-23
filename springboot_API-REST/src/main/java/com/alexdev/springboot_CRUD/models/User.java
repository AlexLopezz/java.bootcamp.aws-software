package com.alexdev.springboot_CRUD.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Builder
@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @NotEmpty(message = "Must be a valid value.")
    private String dni;

    @NotEmpty(message = "Must be a valid value.")
    private String name;

    @NotEmpty(message = "Must be a valid value.")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Must be choose a correct date.")
    @Past(message = "Must be after current date.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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