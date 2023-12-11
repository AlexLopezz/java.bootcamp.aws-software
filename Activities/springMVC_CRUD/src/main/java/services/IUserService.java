package services;

import models.User;

import java.util.Optional;

public interface IUserService extends IService<User> {
    Optional<User> searchByDNI(String dni);
    void deleteBy(String dni);
}
