package com.alexdev.springboot_CRUD.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class UserRequest {
    private Long id;
    private String username;
    private String password;
    private String profession;
    private String role;
}