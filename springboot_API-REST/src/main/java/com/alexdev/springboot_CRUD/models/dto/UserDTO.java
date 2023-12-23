package com.alexdev.springboot_CRUD.models.dto;

import com.alexdev.springboot_CRUD.models.Profession;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@ToString
@Getter @Setter
public class UserDTO {
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

    @NotEmpty(message = "Must be a valid value.")
    private String profession;
}
