package services.impl;

import models.User;
import repositories.IUserRepository;
import repositories.impl.UserRepositoryImpl;
import services.IUserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;

    public UserServiceImpl() throws IOException {
        this.userRepository = new UserRepositoryImpl();
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
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public Optional<User> searchByDNI(String dni) {
        return userRepository.getUserBy(dni);
    }

    @Override
    public void deleteBy(String dni) {
        userRepository.deleteBy(dni);
    }
}
