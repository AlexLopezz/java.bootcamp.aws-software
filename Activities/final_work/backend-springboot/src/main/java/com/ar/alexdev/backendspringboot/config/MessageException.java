package com.ar.alexdev.backendspringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:message.properties")
public class MessageException {
    @Value("${user.NOT_FOUND}")
    public String userNotFound;

    @Value("${user.ALREADY_EXIST}")
    public String userAlreadyExist;
}