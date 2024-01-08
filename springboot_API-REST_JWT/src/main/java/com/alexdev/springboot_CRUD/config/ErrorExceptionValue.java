package com.alexdev.springboot_CRUD.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ErrorExceptionValue {
    @Value("${error.notFound}")
    private String notFound;

    @Value("${error.alreadyExist}")
    private String alreadyExist;
}