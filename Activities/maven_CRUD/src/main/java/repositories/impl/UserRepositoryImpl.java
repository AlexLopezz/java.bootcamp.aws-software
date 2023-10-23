package repositories.impl;

import database.conf.Connection;
import database.conf.IConnectable;
import lombok.SneakyThrows;
import models.User;
import models.enums.PROFESSION;
import repositories.IUserRepository;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class UserRepositoryImpl implements IUserRepository {

    IConnectable conn;

    public UserRepositoryImpl() throws IOException {
        conn = new Connection();
    }

    /**
     *  this metod does not return anything, only save/modify the current user in the database.
     * @param user to save/modify
     */
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
            users.add(user); //will add only if no user is found

        conn.refresh(castToDataSource(users)); //Refresh our datasource, but not before cast to List<String> (DataSource)
    }

    @SneakyThrows
    @Override
    public void delete(User user) {
        this.deleteBy(user.getDni());
    }
    /**
     *  this method will return all the users that are in our database.
     * @return List<User> All Users</User>
     */
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
    public void saveAll(List<User> tts) {
        tts.forEach(this::save);
    }

    /**
     *  this method returns a user by means of the user's DNI
     * @param dni user
     * @return Optional<User> warning - you must find out whether it contains the user... </User>
     */
    @Override
    public Optional<User> getUserBy(String dni) {
        return getAll().stream()
                .filter(u -> u.getDni().equals(dni))
                .findFirst();
    }

    /**
     *  this method will delete a user, by means of his ID (DNI)
     * @param dni existing user's dni
     */
    @SneakyThrows
    @Override
    public void deleteBy(String dni) {
        List<User> users = getAll();

        Optional<User> user = getUserBy(dni);

        user.ifPresent(users::remove);
        conn.refresh(castToDataSource(users));
    }

    //UTILS
    /**
     *  Converts a row from our data source to user
     * @param dataRow from data source
     * @return User object
     */
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

    /**
     *  Converts a list of users to a list of strings (original data source)
     * @param users List<User></User>
     * @return original data source
     */
    private List<String> castToDataSource(List<User> users){
        return users.stream()
                .map(convertToString)
                .toList();
    }

    private static final Function<User, String> convertToString = User::toString;
}
