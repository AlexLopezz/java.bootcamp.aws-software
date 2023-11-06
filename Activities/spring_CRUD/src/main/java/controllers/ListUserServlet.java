package controllers;

import config.AppConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.IUserService;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@Configurable
@WebServlet("/list")
public class ListUserServlet extends HttpServlet {

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
        Optional.ofNullable(userService.getAll())
                .ifPresent(users -> req.setAttribute("users", users));

        req.setAttribute("title", "List of Users!"); //Title of head html.

        getServletContext().getRequestDispatcher("/listUser.jsp").forward(req, resp); //dispatch to view
    }
}