package com.alexdev.springboot_CRUD.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponse {
    private long id;
    private String username;
    private String role;
    private String profession;
}