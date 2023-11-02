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
    }

    @Override
    public List<User> getAll() throws IOException {
        userCache.clear(); //Empty Cache, because we must add again...

        //Adding users that find into file DB:
        if (!conn.getDataSource().isEmpty()) {
            for (String data : conn.getDataSource()) {
                userCache.add(castToUser(data));
            }
        }

        return userCache;
    }

    @Override
    public void save(User user) throws IOException {
        //Check if exist user:
        if(userCache.contains(user)){
            for(int i = 0; i < userCache.size(); i++){
                if(userCache.get(i).getDni().equals(user.getDni())) {
                    userCache.set(i, user); //Replace user by array index
                    break;
                }
            }
        }else
            userCache.add(user); //Only add, if not exist user...

        conn.refresh(castToDataSource(userCache));
    }

    @Override
    public void deleteBy(String DNI) throws IOException {
        //Check if exist user:
        Optional<User> user = getBy(DNI);
        user.ifPresent(userCache::remove); //Only delete if exist user...

        conn.refresh(castToDataSource(userCache)); //Refresh file db
    }

    @Override
    public Optional<User> getBy(String DNI){
        return userCache.stream()
                .filter(u -> u.getDni().equals(DNI)) //Filter by DNI
                .findFirst(); //Warning... if not present, return optional empty
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
