package repositories;

import exceptions.DAOException;
import models.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    void save(User u) throws IOException;
    void deleteBy(String DNI) throws IOException;
    Optional<User> getBy(String DNI);
    List<User> getAll() throws DAOException;
}
