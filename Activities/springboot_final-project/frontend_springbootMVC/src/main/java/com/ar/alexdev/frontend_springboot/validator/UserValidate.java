package com.ar.alexdev.frontend_springboot.validator;

import com.ar.alexdev.frontend_springboot.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserValidate {
    @Autowired
    RestTemplate restTemplate;

    @Value("${url.validator}")
    private String urlValidator;

    public void postValidate(UserDTO user) throws HttpClientErrorException {
        restTemplate
            .postForEntity(urlValidator.concat("/validate/user"), user, UserDTO.class);
    }
    public void putValidate(UserDTO user) throws HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();

        // Crear encabezados para la solicitud PUT
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear el cuerpo de la solicitud (puedes usar un objeto Java o un JSON en formato String)
        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(user, headers);

        // Realizar la solicitud PUT
        restTemplate.exchange(
                urlValidator.concat("/validate/user"),
                HttpMethod.PUT,
                requestEntity,
                String.class
        );
    }
    public void getValidate(String dni) throws HttpClientErrorException{
        restTemplate.getForEntity(
                urlValidator.concat("/validate/user/").concat(dni), String.class
        );
    }
}
