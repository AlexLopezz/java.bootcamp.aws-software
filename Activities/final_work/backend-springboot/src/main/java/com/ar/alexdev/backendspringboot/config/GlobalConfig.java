package com.ar.alexdev.backendspringboot.config;

import com.ar.alexdev.backendspringboot.mappers.UserMapper;
import com.ar.alexdev.backendspringboot.mappers.implementations.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {
    @Bean
    public UserMapper userMapper(){
         return new UserMapperImpl();
    }
}
