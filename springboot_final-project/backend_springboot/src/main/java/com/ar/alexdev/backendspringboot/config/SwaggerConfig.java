package com.ar.alexdev.backendspringboot.config;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Simple API-REST - SpringBoot",
                description = "Welcome to my simple api-rest on SpringBootApp. This is an official documentation about the project.",
                version = "1.0",
                license = @License(
                        name = "License name",
                        url= "https://any-url.com"),
                termsOfService = "Terms of service",
                contact = @Contact(
                        name = "Alex Lopez",
                        email = "alexxxd23@gmail.com",
                        url = "https://www.linkedin.com/in/alexanderlopezz/"
                )
        ),
        servers = {
                @Server(
                        description = "LOCAL - ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class SwaggerConfig { }
