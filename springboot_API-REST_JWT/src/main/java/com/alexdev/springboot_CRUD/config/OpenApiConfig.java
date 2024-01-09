package com.alexdev.springboot_CRUD.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.License;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public Contact getContact(){
         Contact contact = new Contact();
         contact.setName("Alex Lopez");
         contact.setEmail("alexxxd23@gmail.com");
         contact.setUrl("https://www.linkedin.com/in/alexanderlopezz/");

        return contact;
    }
    @Bean
    public License getLicense() {
        License license = new License();
        license.setName("Apache 2.0");
        license.setUrl("http://www.apache.org/licenses/LICENSE-2.0.html");

        return license;
    }
    @Bean
    public Info getInfo(Contact contact, License license){
        return new Info()
                .version("1.0")
                .title("API REST w/ JWT")
                .description("Sample API REST with JWT! :D")
                .contact(contact)
                .license(license);
    }

    @Bean
    public Components getSecuritySchemas() {
        Components components = new Components();
        components.addSecuritySchemes("bearerAuth",
                new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP).in(SecurityScheme.In.HEADER)
                        .description("JWT Bearer Auth").scheme("bearer").bearerFormat("JWT")
                        .name("Authorization"));

        return components;
    }

    @Bean
    public OpenAPI getOpenApi(Info info, List<Server> servers, Components components){
        return new OpenAPI()
                .info(info)
                .components(components);
    }
}