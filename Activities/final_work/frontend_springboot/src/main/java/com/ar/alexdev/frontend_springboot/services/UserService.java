package com.ar.alexdev.frontend_springboot.services;

import com.ar.alexdev.frontend_springboot.model.UserDTO;
import com.ar.alexdev.frontend_springboot.validator.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository
public class UserService {
    @Value("${url.backend}")
    private String urlBackend;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserValidate userValidate;
    public List<UserDTO> getUsers() {
        try {
            UserDTO[] usersData = restTemplate.getForObject(
                    urlBackend.concat("/user"), UserDTO[].class);
            return Arrays.asList(Objects.requireNonNull(usersData));

        }catch (NullPointerException ignored){
            return new LinkedList<>();
        }
    }

    public void save(UserDTO user) throws HttpClientErrorException{
        try {
            userValidate.getValidate(user.getDni());
            userValidate.putValidate(user);
            restTemplate.put(
                    urlBackend.concat("/user"),
                    user
            );
        }catch (HttpClientErrorException e){
            userValidate.postValidate(user);
            restTemplate.postForObject(
                    urlBackend.concat("/user"),
                    user ,
                    UserDTO.class
            );
        }
    }
    public Optional<UserDTO> findBy(String dni) throws HttpClientErrorException{
        ResponseEntity<UserDTO> user=  restTemplate.getForEntity(
                urlBackend.concat("/user/".concat(dni)),
                UserDTO.class
        );

        return Optional.ofNullable(user.getBody());
    }

    public void delete(String dni) throws HttpClientErrorException{
        userValidate.getValidate(dni);
        restTemplate.delete(urlBackend.concat("/user/").concat(dni));
    }

}
