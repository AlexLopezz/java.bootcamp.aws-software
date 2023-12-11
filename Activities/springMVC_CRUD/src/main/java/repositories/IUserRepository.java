package repositories;

import models.User;

import java.util.Optional;

public interface IUserRepository extends IRepository<User> {
    Optional<User> getUserBy(String dni);
    void deleteBy(String dni);
}
