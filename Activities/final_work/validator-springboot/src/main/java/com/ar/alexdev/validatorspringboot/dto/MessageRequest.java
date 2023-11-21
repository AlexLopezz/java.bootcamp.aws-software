package com.ar.alexdev.validatorspringboot.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MessageRequest {
    private String message;
}
