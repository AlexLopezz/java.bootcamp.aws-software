package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.SneakyThrows;
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
        Optional<String> dniUser = Optional.ofNullable(req.getParameter("dni"));
        dniUser.ifPresent(u -> {
            Optional<User> userDB = userService.getBy(u);
            userDB.ifPresent(user -> req.setAttribute("user", user));
        });
        req.setAttribute("professions", PROFESSION.values());
        req.setAttribute("title", "User management");
        getServletContext().getRequestDispatcher("/formUser.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String dni = req.getParameter("dni");
        LocalDate dateBirth = LocalDate.parse(req.getParameter("dateBirth"));
        PROFESSION profession = PROFESSION.valueOf(req.getParameter("profession"));

        userService.save(User.builder()
                            .dni(dni)
                            .name(name)
                            .lastName(lastName)
                            .dateBirth(dateBirth)
                            .profession(profession)
                        .build()
        );

        resp.sendRedirect(req.getContextPath().concat("/list"));
    }
}
