package services.impl;

import config.AppConfig;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import repositories.IUserRepository;
import services.IUserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        this.userRepository = context.getBean(IUserRepository.class);

        context.close();
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
