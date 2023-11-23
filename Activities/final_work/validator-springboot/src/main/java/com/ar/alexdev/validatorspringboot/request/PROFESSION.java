package com.ar.alexdev.validatorspringboot.request;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum PROFESSION {
    BACKEND_DEVELOPER("Backend Developer"),
    FRONTEND_DEVELOPER("Frontend Developer"),
    TESTER_QA("Tester QA"),
    FULLSTACK_DEVELOPER("Fullstack Developer");

    @JsonValue
    private final String value;


    PROFESSION(String v) {
        this.value = v;
    }
}
