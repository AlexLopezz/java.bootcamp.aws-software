package com.ar.alexdev.validatorspringboot.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "validation")
@Getter @Setter
public class UserExceptionProperties {
    public Map<String, String> user;
}
