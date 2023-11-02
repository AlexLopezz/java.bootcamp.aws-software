package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.UserRepository;
import services.IUserService;
import services.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/list")
public class ListUserServlet extends HttpServlet {

    private final IUserService userService;

    public ListUserServlet() throws IOException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional.ofNullable(userService.getAll())
                .ifPresent(users -> req.setAttribute("users", users));

        req.setAttribute("title", "Welcome - List of Users!"); //Title of head html.

        getServletContext().getRequestDispatcher("/listUser.jsp").forward(req, resp); //dispatch to view
    }
}