package com.ar.alexdev.frontend_springboot.services;

import com.ar.alexdev.frontend_springboot.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProfessionService {
    @Value("${url.backend}")
    private String urlBackend;


    @Autowired
    RestTemplate restTemplate;


    public List<Profession> getAll(){
        return Arrays
                .stream(
                        Objects
                                .requireNonNull(
                                        restTemplate
                                                .getForObject(
                                                        urlBackend.concat("/profession"),
                                                        Profession[].class)
                                )
                )
                .toList();
    }
}
