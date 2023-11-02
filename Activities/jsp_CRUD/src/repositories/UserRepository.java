package repositories;

import database.conf.Connection;
import database.conf.IConnectable;
import models.User;
import models.enums.PROFESSION;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class UserRepository implements IUserRepository{
    IConnectable conn;

    public UserRepository() throws IOException {
        conn = new Connection();
    }

    @Override
    public List<User> getAll() throws IOException {
        List<User> users = new LinkedList<>();

        if (!conn.getDataSource().isEmpty()) {
            for (String data : conn.getDataSource()) {
                users.add(castToUser(data));
            }
        }

        return users;
    }

    @Override
    public void save(User user) throws IOException {
        List<User> users = getAll();

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

    @Override
    public void deleteBy(String DNI) throws IOException {
        List<User> users = getAll();

        Optional<User> user = getBy(DNI);

        user.ifPresent(users::remove);
        conn.refresh(castToDataSource(users));
    }

    @Override
    public Optional<User> getBy(String DNI) throws IOException {
        return getAll().stream()
                .filter(u -> u.getDni().equals(DNI))
                .findFirst();
    }


    //UTILS
    private User castToUser(String dataRow){
        String[] fields = dataRow.split(";");
        return new User(
                fields[0],
                fields[1],
                fields[2],
                LocalDate.parse(fields[3]),
                PROFESSION.valueOf(fields[4])
        );
    }
    private List<String> castToDataSource(List<User> users){
        return users.stream()
                .map(convertToString)
                .toList();
    }
    private static final Function<User, String> convertToString = User::toString;
}
