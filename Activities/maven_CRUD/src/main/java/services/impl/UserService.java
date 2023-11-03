package services.impl;

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
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    @Override
    public void deleteBy(String dni) {
        userRepository.deleteBy(dni);
    }


    @Override
    public Optional<User> getBy(String dni) {
        return userRepository.getBy(dni);
    }
}
