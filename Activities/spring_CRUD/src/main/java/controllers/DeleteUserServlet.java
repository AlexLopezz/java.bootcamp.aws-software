package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.IUserService;

import java.io.IOException;
import java.util.Optional;

@Controller
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    IUserService userService;

    public DeleteUserServlet() throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.userService = context.getBean(IUserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> dni = Optional.ofNullable(req.getParameter("dni")); //We wrap the DNI parameter
        dni.ifPresent(d -> userService.deleteBy(d));


        resp.sendRedirect(req.getContextPath().concat("/list")); //redirect to /list(controller)...
    }
}
