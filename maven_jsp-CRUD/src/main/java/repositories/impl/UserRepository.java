package repositories.impl;

import database.conf.Connection;
import database.conf.IConnectable;
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
    private final List<User> usersCache;
    public UserRepository() throws IOException {
        conn = new Connection();
        usersCache = new LinkedList<>();
        getAll();
    }

    @Override
    public List<User> getAll() {
        usersCache.clear();
        if (!conn.getDataSource().isEmpty()) {
            for (String data : conn.getDataSource()) {
                usersCache.add(castToUser(data));
            }
        }

        return usersCache;
    }

    @Override
    public void save(User user){
        if (usersCache.contains(user)) {
            int indexUserToReplace = userIndexList(user, usersCache);
            usersCache.set(indexUserToReplace, user);

        } else
            usersCache.add(user);

        conn.refresh(castToDataSource(usersCache));
    }

    @Override
    public void deleteBy(String DNI) {
        getBy(DNI).ifPresent(usersCache::remove);
        conn.refresh(castToDataSource(usersCache));
    }

    @Override
    public Optional<User> getBy(String DNI) {
        return usersCache.stream()
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
    private static final Function<User, String> convertToString = User::toString;
    private static final Function<String[], User> convertToUser = (f) -> new User(f[0], f[1], f[2], LocalDate.parse(f[3]), PROFESSION.valueOf(f[4]));
    private int userIndexList(User user, List<User> users){
        return IntStream.range(0, users.size())
                .filter(i -> Objects.equals(users.get(i), user))
                .findFirst()
                .orElse(-1);
    }
}