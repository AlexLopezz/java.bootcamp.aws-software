package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
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
        String titleAndHeader = "List of Users!";
        req.setAttribute("headerPage", titleAndHeader);
        req.setAttribute("title", titleAndHeader);

        Optional.ofNullable(userService.getAll())
                .ifPresent(users -> req.setAttribute("users", users));

        getServletContext().getRequestDispatcher("/listUser.jsp").forward(req, resp);
    }
}