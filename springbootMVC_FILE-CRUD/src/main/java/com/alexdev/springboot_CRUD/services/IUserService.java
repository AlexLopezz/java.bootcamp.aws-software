package com.alexdev.springboot_CRUD.services;

import com.alexdev.springboot_CRUD.models.User;
import java.util.Optional;

public interface IUserService extends IService<User> {
    Optional<User> searchByDNI(String dni);
    void deleteBy(String dni);
}
