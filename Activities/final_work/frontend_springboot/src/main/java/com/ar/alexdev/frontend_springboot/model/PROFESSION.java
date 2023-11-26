package com.ar.alexdev.frontend_springboot.model;

import lombok.Getter;

@Getter
public enum PROFESSION {
    BACKEND_DEVELOPER("Backend Developer"),
    FRONTEND_DEVELOPER("Frontend Developer"),
    QA_TESTER("Tester QA"),
    FULLSTACK_DEVELOPER("Fullstack Developer");


    private final String value;

    PROFESSION(String s) {
        this.value = s;
    }
}
