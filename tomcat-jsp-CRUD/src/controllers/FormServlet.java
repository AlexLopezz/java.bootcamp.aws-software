package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import models.enums.PROFESSION;
import repositories.UserRepository;
import services.IUserService;
import services.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet("/form")
public class FormServlet extends HttpServlet {

    private final IUserService userService;

    public FormServlet() throws IOException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("headerPage", "User Form");
        req.setAttribute("title", "Create user");

        String dni = req.getParameter("dni");
        Optional.ofNullable(dni)
                .flatMap(userService::getBy)
                .ifPresent(u -> {
                    req.setAttribute("user", u);
                    req.setAttribute("title", "Update user");
                });

        req.setAttribute("professions", PROFESSION.values());
        getServletContext().getRequestDispatcher("/formUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String dni = req.getParameter("dni");
        LocalDate dateBirth = LocalDate.parse(req.getParameter("dateBirth"));
        PROFESSION profession = PROFESSION.valueOf(req.getParameter("profession"));

        userService.save(new User(dni, name, lastName, dateBirth, profession));

        resp.sendRedirect(req.getContextPath().concat("/list"));
    }
}
