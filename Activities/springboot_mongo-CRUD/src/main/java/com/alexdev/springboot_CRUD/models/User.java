package com.alexdev.springboot_CRUD.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "db_user")
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


    @NotNull(message = "Must be choose a correct date.")
    @Past(message = "Must be after current date.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBirth;

    private Profession profession;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User u)
            return this.getDni().equals(u.getDni());

        return false;
    }
}