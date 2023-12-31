package com.ar.alexdev.validatorspringboot.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:message.properties")
public class ExceptionMessage {
    @Value("${user.WITHOUT_ANY_VALUE}")
    public String messageWithoutAnyValue;

    @Value("${user.NOT_FOUND}")
    public String messageNotFound;

    @Value("${user.EXIST}")
    public String messageAlreadyExist;
}