package com.ar.alexdev.frontend_springboot.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Util {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
