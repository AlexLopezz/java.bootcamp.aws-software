package repositories.impl;

import database.conf.Connection;
import database.conf.IConnectable;
import lombok.SneakyThrows;
import models.User;
import models.enums.PROFESSION;
import repositories.IUserRepository;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class UserRepository implements IUserRepository {

    private final IConnectable conn;

    public UserRepository() throws IOException {
        conn = new Connection();
    }


    @SneakyThrows
    public void save(User user) {
        List<User> users= getAll();

        //Searching user in our current datasource:
        if(users.contains(user)){
            for(int i = 0; i < users.size(); i++){
                if(users.get(i).getDni().equals(user.getDni())) {
                    users.set(i, user);
                    break;
                }
            }
        }else
            users.add(user);

        conn.refresh(castToDataSource(users));
    }

    @SneakyThrows
    @Override
    public List<User> getAll() {
        List<User> users = new LinkedList<>();
        if(!conn.getDataSource().isEmpty()) {
            for (String data : conn.getDataSource()) {
                users.add(castToUser(data));
            }
        }

        return users;
    }

    @Override
    public Optional<User> getBy(String dni) {
        return getAll().stream()
                .filter(u -> u.getDni().equals(dni))
                .findFirst();
    }

    @SneakyThrows
    @Override
    public void deleteBy(String dni) {
        List<User> users = getAll();

        Optional<User> user = getBy(dni);

        user.ifPresent(users::remove);
        conn.refresh(castToDataSource(users));
    }

    //UTILS
    private User castToUser(String dataRow) throws ParseException {
        String[] fields = dataRow.split(";");

        return User.builder()
                    .dni(fields[0])
                    .name(fields[1])
                    .lastName(fields[2])
                    .dateBirth(LocalDate.parse(fields[3]))
                    .profession(PROFESSION.valueOf(fields[4]))
                .build();
    }


    private List<String> castToDataSource(List<User> users){
        return users.stream()
                .map(convertToString)
                .toList();
    }

    private static final Function<User, String> convertToString = User::toString;
}
