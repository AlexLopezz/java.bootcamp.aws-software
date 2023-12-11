package com.ar.alexdev.cxfspringbootws_CRUD.services.impl;

import com.ar.alexdev.cxfspringbootws_CRUD.models.User;
import com.ar.alexdev.cxfspringbootws_CRUD.repositories.UserRepository;
import com.ar.alexdev.cxfspringbootws_CRUD.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User deleteUser(String DNI) {
        User usrToDelete = getUser(DNI);
        repository.deleteById(DNI);

        return usrToDelete;
    }

    @Override
    public User saveUser(User u) {
        return repository.save(u);
    }

    @Override
    public User updateUser(User u ) {
        try {
            User usrToUpdate = getUser(u.getDNI());
            return repository.save(usrToUpdate);

        }catch (RuntimeException e){
            throw new RuntimeException("User not exist into Database.");
        }
    }

    @Override
    public User getUser(String DNI) {
        return repository.findById(DNI)
                .orElseThrow();
    }
}
