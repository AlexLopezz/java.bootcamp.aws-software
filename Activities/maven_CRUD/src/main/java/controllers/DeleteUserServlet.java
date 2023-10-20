package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.IUserService;
import services.impl.UserServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    IUserService userService;

    public DeleteUserServlet() throws IOException {
         userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> dni = Optional.ofNullable(req.getParameter("dni")); //We wrap the DNI parameter
        dni.ifPresent(d -> userService.deleteBy(d));


        resp.sendRedirect(req.getContextPath().concat("/list")); //redirect to /list(controller)...
    }
}
