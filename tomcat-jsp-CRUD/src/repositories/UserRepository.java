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
    private final IConnectable conn;
    private final List<User> userCache;

    public UserRepository() throws IOException {
        conn = new Connection();
        userCache = new LinkedList<>();
        getAll();
    }

    @Override
    public List<User> getAll() {
        userCache.clear();

        if (!conn.getDataSource().isEmpty()) {
            for (String data : conn.getDataSource()) {
                userCache.add(castToUser(data));
            }
        }

        return userCache;
    }

    @Override
    public void save(User user) {
        if(userCache.contains(user)){
            for(int i = 0; i < userCache.size(); i++){
                if(userCache.get(i).getDni().equals(user.getDni())) {
                    userCache.set(i, user);
                    break;
                }
            }
        }else
            userCache.add(user);

        conn.refresh(castToDataSource(userCache));
    }

    @Override
    public void deleteBy(String DNI) {
        getBy(DNI).ifPresent(userCache::remove);
        conn.refresh(castToDataSource(userCache));
    }

    @Override
    public Optional<User> getBy(String DNI){
        return userCache.stream()
                .filter(u -> u.getDni().equals(DNI))
                .findFirst();
    }

    private User castToUser(String dataRow){
        return convertToUser.apply(dataRow.split(";"));
    }
    private List<String> castToDataSource(List<User> users){
        return users.stream()
                .map(convertToString)
                .toList();
    }

    private static final Function<String[], User> convertToUser = (f) -> new User(
            f[0],
            f[1],
            f[2],
            LocalDate.parse(f[3]),
            PROFESSION.valueOf(f[4])
    );
    private static final Function<User, String> convertToString = User::toString;
}
