package com.alexdev.springboot_CRUD.services.impl;

import com.alexdev.springboot_CRUD.exceptions.NotFoundExcepcion;
import com.alexdev.springboot_CRUD.models.User;
import com.alexdev.springboot_CRUD.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Stream;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDetails = repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundExcepcion(User.class.getSimpleName()));

        Collection<? extends GrantedAuthority> authorities = Stream.of(userDetails.getRole())
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName())))
                .toList();

        return new org.springframework.security.core.userdetails.User(
                userDetails.getUsername(),
                userDetails.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }
}
