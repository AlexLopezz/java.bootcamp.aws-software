package com.alexdev.springboot_CRUD.repositories;

import com.alexdev.springboot_CRUD.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    User save(User user);
    Optional<User> findByDNI(String DNI);
    void deleteByDNI(String DNI);
}