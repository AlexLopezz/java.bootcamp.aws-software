package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.IUserService;
import services.impl.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private final IUserService userService;

    public DeleteUserServlet() throws IOException {
         userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> dni = Optional.ofNullable(req.getParameter("dni"));
        dni.ifPresent(d -> {
            try {
                userService.deleteBy(d);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        resp.sendRedirect(req.getContextPath().concat("/list"));
    }
}