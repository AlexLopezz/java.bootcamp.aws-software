package com.ar.alexdev.backendspringboot.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class MessageResponse {
    private String message;
}
