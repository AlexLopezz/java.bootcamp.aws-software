package com.ar.alexdev.validatorspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "exception")
public class UserExceptionProperties {
    Map<String, String> user;
}
