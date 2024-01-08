package com.alexdev.springboot_CRUD.models.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) //Cast to snake_case
public class MessageErrorResponse {
    private String errorMessage;
}