package com.alexdev.springBoot_CRUD.services;

import com.alexdev.springBoot_CRUD.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserService {
    List<User> getAll();
    User save(User user);
    Optional<User> getBy(String dni);
    void delete(String dni);
}
