package com.alexdev.springboot_CRUD.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthRequest {
    private String username;
    private String password;
}
