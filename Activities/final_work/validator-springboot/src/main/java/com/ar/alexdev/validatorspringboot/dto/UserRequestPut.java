package com.ar.alexdev.validatorspringboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter @Setter
public class UserRequestPut {
    @NotEmpty
    @Pattern(regexp = "[0-9]{8}")
    private String dni;


    @Length(min=3, max = 30)
    private String name;

    @Length(min=3, max = 50)
    private String lastName;

    @Pattern(regexp = "\\w+@\\w+\\.\\w+")
    private String email;

    @Pattern(regexp = "^\\+54\\s(\\d{2,4})(\\-|\\s)(\\d{6,8})$")
    private String phone;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date dateBirth;

    private PROFESSION profession;
}
