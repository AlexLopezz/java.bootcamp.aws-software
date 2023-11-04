package repositories.impl;

import database.conf.Connection;
import database.conf.IConnectable;
import exceptions.DAOException;
import exceptions.NotFoundException;
import models.User;
import models.enums.PROFESSION;
import repositories.IUserRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class UserRepository implements IUserRepository{
    private final IConnectable conn;
    private final List<User> userCache;

    public UserRepository() throws IOException {
        conn = new Connection();
        userCache = new LinkedList<>();
    }

    @Override
    public List<User> getAll() throws DAOException {
        try {
            userCache.clear(); //Empty Cache, because we must add again...
            //Adding users that find into file DB:
            if (!conn.getDataSource().isEmpty()) {
                for (String data : conn.getDataSource()) {
                    userCache.add(castToUser(data));
                }
            }

            return userCache;
        }catch (IOException e){
            throw new DAOException("There was an error when try list of users...");
        }
    }

    @Override
    public void save(User user) throws IOException {
        //Check if exist user:
        if (userCache.contains(user)) {
            int indexUserToReplace = userIndexList(user);
            userCache.set(indexUserToReplace, user); //Replace user by array index

        } else
            userCache.add(user); //Only add, if not exist user...

        conn.refresh(castToDataSource(userCache));
    }


    @Override
    public void deleteBy(String DNI) throws IOException {
            //Check if exist user:
            getBy(DNI).ifPresent(userCache::remove);
            conn.refresh(castToDataSource(userCache)); //Refresh file db
    }

    @Override
    public Optional<User> getBy(String DNI){
        return userCache.stream()
                    .filter(u -> u.getDni().equals(DNI)) //Filter by DNI
                    .findFirst();
    }

    //UTILS
    private User castToUser(String dataRow){
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
    private int userIndexList(User user){
        return IntStream.range(0, userCache.size())
                .filter(i -> Objects.equals(userCache.get(i), user))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}