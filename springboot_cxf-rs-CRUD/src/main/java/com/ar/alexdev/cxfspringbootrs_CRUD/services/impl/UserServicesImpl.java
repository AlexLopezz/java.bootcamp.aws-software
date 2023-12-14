package com.ar.alexdev.cxfspringbootws_CRUD.services.impl;

import com.ar.alexdev.cxfspringbootws_CRUD.models.User;
import com.ar.alexdev.cxfspringbootws_CRUD.repositories.UserRepository;
import com.ar.alexdev.cxfspringbootws_CRUD.services.UserServices;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServicesImpl implements UserServices {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Response deleteUser(String DNI) {
        repository.deleteById(DNI);

        return Response.ok()
                .build();
    }

    @Override
    public Response saveUser(User u) {
        User usrSaved = repository.save(u);

        return Response.ok(usrSaved).build();
    }

    @Override
    public Response updateUser(User u ) {
        Optional<User> usrFound = repository.findById(u.getDNI());

        return Response.ok(usrFound).build();
    }

    @Override
    public Response getUser(String DNI) {
        User u = repository.findById(DNI).orElseThrow();

        return Response.ok(u).build();
    }
}
