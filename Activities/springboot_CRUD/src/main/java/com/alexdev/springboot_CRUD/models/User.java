package com.alexdev.springboot_CRUD.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import com.alexdev.springboot_CRUD.models.enums.PROFESSION;

import java.time.LocalDate;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty(message = "Must be a valid value.")
    @Size(min=8, max = 8, message = "Check this field...DNI must be 8 digits long.")
    private String dni;

    @NotEmpty(message = "Must be a valid value.")
    private String name;

    @NotEmpty(message = "Must be a valid value.")
    private String lastName;

    @Past(message = "Date must be after current date.")
    private LocalDate dateBirth;

    @NotEmpty
    private PROFESSION profession;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User u)
            return this.getDni().equals(u.getDni());

        return false;
    }

    @Override
    public String toString() {
        return dni.concat(";")
                .concat(name).concat(";")
                .concat(lastName).concat(";")
                .concat(dateBirth.toString()).concat(";")
                .concat(profession.name());
    }
}