package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.AppConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import services.IUserService;
import services.impl.UserServiceImpl;

import java.io.IOException;
import java.util.Optional;

@Configurable
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
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
        Optional<String> dni = Optional.ofNullable(req.getParameter("dni")); //We wrap the DNI parameter
        dni.ifPresent(d -> userService.deleteBy(d));


        resp.sendRedirect(req.getContextPath().concat("/list")); //redirect to /list(controller)...
    }
}
