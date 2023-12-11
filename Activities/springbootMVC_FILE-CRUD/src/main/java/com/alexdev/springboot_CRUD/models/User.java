package com.alexdev.springboot_CRUD.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import com.alexdev.springboot_CRUD.models.enums.PROFESSION;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
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

    private PROFESSION profession;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User u)
            return this.getDni().equals(u.getDni());

        return false;
    }

    @Override
    public String toString() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return dni.concat(";")
                .concat(name).concat(";")
                .concat(lastName).concat(";")
                .concat(sdf.format(dateBirth)).concat(";")
                .concat(profession.name());
    }
}