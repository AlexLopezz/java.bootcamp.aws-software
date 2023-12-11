package com.ar.alexdev.frontend_springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    Map<String, Object> cache(){
        return new LinkedHashMap<>();
    }
}
