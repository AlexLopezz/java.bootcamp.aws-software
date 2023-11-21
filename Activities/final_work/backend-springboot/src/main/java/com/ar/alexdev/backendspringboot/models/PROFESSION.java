package com.ar.alexdev.backendspringboot.models;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum PROFESSION {
    BACKEND_DEVELOPER("Backend Developer"),
    FRONTEND_DEVELOPER("Frontend Developer"),
    QA_TESTER("Tester QA"),
    FULLSTACK_DEVELOPER("Fullstack Developer");

    @JsonValue
    private final String value;

    PROFESSION(String s) {
        this.value = s;
    }
}

