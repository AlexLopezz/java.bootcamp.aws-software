package com.ar.alexdev.frontend_springboot.validator;

import com.ar.alexdev.frontend_springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserValidate {
    @Autowired
    RestTemplate restTemplate;

    @Value("${url.validator}")
    private String urlValidator;

    public void postValidate(User user) throws HttpClientErrorException {
        ResponseEntity<User> response = restTemplate
                .postForEntity(urlValidator, user, User.class);
    }
}
