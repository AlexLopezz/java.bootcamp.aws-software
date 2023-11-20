package com.ar.alexdev.validatorspringboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter @Setter
public class UserRequestPost {
    @NotEmpty
    @Pattern(regexp = "[0-9]{8}")
    private String dni;

    @NotEmpty
    @Length(min=3, max = 30)
    private String name;

    @NotEmpty
    @Length(min=3, max = 50)
    private String lastName;

    @NotEmpty
    @Pattern(regexp = "\\w+@\\w+\\.\\w+")
    private String email;

    @NotEmpty
    @Pattern(regexp = "^\\+54\\s(\\d{2,4})(\\-|\\s)(\\d{6,8})$")
    private String phone;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @NotNull
    private Date dateBirth;

    @NotNull
    private PROFESSION profession;
}
