package com.ar.alexdev.validatorspringboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter @Setter
public class UserDTO {
    @NotEmpty(message = "Must have a valid value.")
    @Pattern(regexp = "[0-9]{8}", message = "No contains dni format")
    private String dni;

    @Length(max = 50)
    @NotEmpty(message = "Must have a valid value.")
    private String name;

    @NotEmpty(message = "Must have a valid value.")
    @Length(max = 50)
    private String lastName;

    @NotEmpty(message = "Must have a valid value.")
    @Pattern(regexp = "([a-z]|[0-9])+@[a-z]+\\.[a-z]+", message = "No format email.")
    private String email;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd")
    @NotNull(message = "Must have a valid value.")
    private Date dateBirth;
}
