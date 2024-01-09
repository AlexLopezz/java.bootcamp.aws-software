package com.alexdev.springboot_CRUD.services.impl;

import com.alexdev.springboot_CRUD.exceptions.NotFoundExcepcion;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.models.dto.AuthRequest;
import com.alexdev.springboot_CRUD.models.dto.AuthResponse;
import com.alexdev.springboot_CRUD.repositories.IUserRepository;
import com.alexdev.springboot_CRUD.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final IUserRepository repository;

    private final JWTUtils jwtUtils;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, IUserRepository repository, JWTUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.jwtUtils = jwtUtils;
    }

    public AuthResponse login(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(), authRequest.getPassword());

        authenticationManager.authenticate(authToken);
        User user = repository.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new NotFoundExcepcion(User.class.getSimpleName()));

        return AuthResponse.builder()
                .token(jwtUtils.generateToken(user.getUsername()))
                .build();
    }
}
