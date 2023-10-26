package services.impl;

import config.AppConfig;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.IUserRepository;
import services.IUserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;

    public UserServiceImpl() throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.userRepository = context.getBean(IUserRepository.class);
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
