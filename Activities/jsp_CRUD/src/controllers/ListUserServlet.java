package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.UserRepository;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/list")
public class ListUserServlet extends HttpServlet {

    UserRepository userRepository;

    public ListUserServlet() throws IOException {
        userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional.ofNullable(userRepository.getAllUsers())
                .ifPresent(users -> req.setAttribute("users", users));

        req.setAttribute("title", "Welcome - List of Users!"); //Title of head html.

        getServletContext().getRequestDispatcher("/listUser.jsp").forward(req, resp); //dispatch to view
    }
}