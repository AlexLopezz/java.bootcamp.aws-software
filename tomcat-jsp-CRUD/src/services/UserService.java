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
    public List<User> getAll(){
        return userRepository.getAll();
    }

    @Override
    public void save(User u){
        userRepository.save(u);
    }

    @Override
    public void deleteBy(String DNI){
        userRepository.deleteBy(DNI);
    }

    @Override
    public Optional<User> getBy(String DNI) {
        return userRepository.getBy(DNI);
    }
}
