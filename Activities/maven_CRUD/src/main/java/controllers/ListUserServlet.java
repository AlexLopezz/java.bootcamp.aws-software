package controllers;

import services.IUserService;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Optional;

@WebServlet("/list")
public class ListUserServlet extends HttpServlet {

    IUserService userService;

    public ListUserServlet() throws IOException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional.ofNullable(userService.getAll())
                .ifPresent(users -> req.setAttribute("users", users));

        req.setAttribute("title", "List of Users!"); //Title of head html.

        getServletContext().getRequestDispatcher("/listUser.jsp").forward(req, resp); //dispatch to view
    }
}