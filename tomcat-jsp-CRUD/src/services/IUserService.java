package services;

import models.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    void save(User u);
    void deleteBy(String DNI);
    Optional<User> getBy(String DNI);
}
