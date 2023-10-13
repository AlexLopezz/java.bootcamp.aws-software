package services;

import jakarta.servlet.http.HttpSession;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
    private final HttpSession session;
    public UserService(HttpSession session){
        this.session = session;
        List<User> users = new ArrayList<>();
        session.setAttribute("users", users);
    }
    public void save(User user){
        var users = list();
        users.add(user);
    }

    public List<User> list(){
        return (List<User>) session.getAttribute("users");
    }
}
