package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.enums.PROFESSION;
import services.IUserService;
import services.impl.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
    private final IUserService userService;

    public FormServlet() throws IOException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("headerPage", "User form");
        req.setAttribute("title", "Create user");
        req.setAttribute("professions", PROFESSION.values());

        Optional.ofNullable(req.getParameter("dni"))
                .flatMap(userService::getBy)
                .ifPresent(u -> {
                    req.setAttribute("user", u);
                    req.setAttribute("title", "Update user");
                });

        getServletContext().getRequestDispatcher("/formUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User userToSave = User.builder()
                .dni(req.getParameter("dni"))
                .name(req.getParameter("name"))
                .lastName(req.getParameter("lastName"))
                .dateBirth(LocalDate.parse(req.getParameter("dateBirth")))
                .profession(PROFESSION.valueOf(req.getParameter("profession")))
                .build();

        userService.save(userToSave);
        resp.sendRedirect(req.getContextPath().concat("/list"));
    }
}