package services.impl;

import models.User;
import repositories.IUserRepository;
import repositories.impl.UserRepository;
import services.IUserService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private List<User> cacheService;

    public UserService() throws IOException {
        this.userRepository = new UserRepository();
        cacheService = new LinkedList<>();
        getAll();
    }

    @Override
    public List<User> getAll() {
        cacheService = userRepository.getAll();
        return cacheService;
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
        Optional<User> userCache=  cacheService
                                            .stream()
                                            .filter(u -> u.getDni().equals(dni))
                                            .findFirst();

        return userCache.isPresent()? userCache : userRepository.getBy(dni);
    }
}