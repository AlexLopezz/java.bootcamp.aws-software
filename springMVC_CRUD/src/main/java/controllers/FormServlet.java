package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.AppConfig;
import lombok.SneakyThrows;
import models.User;
import models.enums.PROFESSION;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import services.IUserService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Configurable
@WebServlet("/form")
public class FormServlet extends HttpServlet {
    private IUserService userService;


    @Override
    public void init() throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        this.userService = context.getBean(IUserService.class);

        context.close();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> dniUser = Optional.ofNullable(req.getParameter("dni"));
        dniUser.ifPresent(u -> {
            Optional<User> userDB = userService.searchByDNI(u);
            userDB.ifPresent(user -> req.setAttribute("user", user));
        });
        req.setAttribute("professions", PROFESSION.values());
        req.setAttribute("title", "User management");
        getServletContext().getRequestDispatcher("/formUser.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        //Redireccionamos hacia la lista de usuarios:
        resp.sendRedirect(req.getContextPath().concat("/list"));
    }
}
