package com.ar.alexdev.frontend_springboot.services;

import com.ar.alexdev.frontend_springboot.model.User;
import com.ar.alexdev.frontend_springboot.validator.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserService {
    @Value("${url.backend}")
    private String urlBackend;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserValidate userValidate;

    public List<User> getUsers() {
        User[] usersData = restTemplate.getForObject(
                urlBackend.concat("/user"), User[].class);
        return Arrays.asList(Objects.requireNonNull(usersData));
    }

    public User save(User user) throws HttpClientErrorException{
        userValidate.postValidate(user);
        ResponseEntity<User> userResponse = restTemplate.postForEntity(urlBackend, user ,User.class);

        return userResponse.getBody();
    }

}
