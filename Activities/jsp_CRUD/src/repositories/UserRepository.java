package repositories;

import database.conf.Connection;
import database.conf.IConnectable;
import models.User;
import models.enums.PROFESSION;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class UserRepository {

    IConnectable conn;

    public UserRepository() throws IOException {
        conn = new Connection();
    }

    /**
     *  this method will return all the users that are in our database.
     * @return List<User> All Users</User>
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    public List<User> getAllUsers() throws IOException {
        List<User> users = new LinkedList<>();

        if(!conn.getDataSource().isEmpty()) {
            for (String data : conn.getDataSource()) {
                users.add(castToUser(data));
            }
        }

        return users;
    }

    /**
     *  this metod does not return anything, only save/modify the current user in the database.
     * @param user to save/modify
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    public void save(User user) throws IOException {
        List<User> usersToRefresh = getAllUsers();

        //Searching user in our current datasource:
        if(usersToRefresh.contains(user)){
            for(int i = 0; i < usersToRefresh.size(); i++){
                if(usersToRefresh.get(i).getDni().equals(user.getDni())) {
                    usersToRefresh.set(i, user);
                    break;
                }
            }
        }else
            usersToRefresh.add(user); //will add only if no user is found

        conn.refresh(castToDataSource(usersToRefresh)); //Refresh our datasource, but not before cast to List<String> (DataSource)
    }

    /**
     *  this method returns a user by means of the user's DNI
     * @param dni user
     * @return Optional<User> warning - you must find out whether it contains the user... </User>
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    public Optional<User> searchByDNI(String dni) throws IOException {
        return getAllUsers().stream()
                .filter(u -> u.getDni().equals(dni))
                .findFirst();
    }

    /**
     *  this method will delete a user, by means of his ID (DNI)
     * @param dni existing user's dni
     * @throws IOException warning - this occurs when there are problems in the data reading.
     */
    public void delete(String dni) throws IOException {
        List<User> users = getAllUsers();

        Optional<User> user = users.stream()
                                    .filter(u -> u.getDni().equals(dni))
                                    .findFirst();

        user.ifPresent(users::remove);
        conn.refresh(castToDataSource(users));
    }


    //UTILS

    /**
     *  Converts a row from our data source to user
     * @param dataRow from data source
     * @return User object
     */
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

    /**
     *  Converts a list of users to a list of strings (original data source)
     * @param users List<User></User>
     * @return original data source
     */
    private List<String> castToDataSource(List<User> users){
        StringBuilder sb = new StringBuilder();
        users.forEach(sb::append);

        return Arrays.stream(sb.toString().split(",")).toList();
    }
}
