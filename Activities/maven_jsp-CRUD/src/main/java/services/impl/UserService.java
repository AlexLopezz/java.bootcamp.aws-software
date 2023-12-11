package services.impl;

import exceptions.DAOException;
import exceptions.NotFoundException;
import models.User;
import repositories.IUserRepository;
import repositories.impl.UserRepository;
import services.IUserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {
    private final IUserRepository userRepository;

    public UserService() throws IOException {
        this.userRepository = new UserRepository();
    }

    @Override
    public List<User> getAll() throws DAOException {
        return userRepository.getAll();
    }

    @Override
    public void save(User user) throws IOException {
        userRepository.save(user);
    }

    @Override
    public void deleteBy(String dni) throws IOException {
        userRepository.deleteBy(dni);
    }


    @Override
    public Optional<User> getBy(String dni) {
        return userRepository.getBy(dni);
    }
}