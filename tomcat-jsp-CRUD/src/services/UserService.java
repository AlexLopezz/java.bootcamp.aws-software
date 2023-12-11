package services;

import models.User;
import repositories.IUserRepository;
import repositories.UserRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserService implements IUserService{
    private final IUserRepository userRepository;

    public UserService() throws IOException {
        this.userRepository = new UserRepository();
    }

    @Override
    public List<User> getAll() throws IOException {
        return userRepository.getAll();
    }

    @Override
    public void save(User u) throws IOException {
        userRepository.save(u);
    }

    @Override
    public void deleteBy(String DNI) throws IOException {
        userRepository.deleteBy(DNI);
    }

    @Override
    public Optional<User> getBy(String DNI) throws IOException {
        return userRepository.getBy(DNI);
    }
}
