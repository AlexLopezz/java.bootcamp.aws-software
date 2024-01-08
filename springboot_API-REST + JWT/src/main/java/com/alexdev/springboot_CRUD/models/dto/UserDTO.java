package com.alexdev.springboot_CRUD.models.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@ToString
@Getter @Setter
public class UserDTO {
    @NotEmpty(message = "Must be a valid value.")
    private String username;

    @NotEmpty(message = "Must be a valid value.")
    private String password;

    @NotEmpty(message = "Field must have a valid value")
    private String profession;

    @NotEmpty(message = "Field must have a valid value")
    private String role;
}