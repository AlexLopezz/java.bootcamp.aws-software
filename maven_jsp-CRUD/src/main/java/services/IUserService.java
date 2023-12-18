package services;

import models.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    void save(User u);
    void deleteBy(String DNI);
    Optional<User> getBy(String DNI);
    List<User> getAll();
}
