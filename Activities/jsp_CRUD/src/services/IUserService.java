package services;

import models.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll() throws IOException;
    void save(User u) throws IOException;
    void deleteBy(String DNI) throws IOException;
    Optional<User> getBy(String DNI) throws IOException;
}
