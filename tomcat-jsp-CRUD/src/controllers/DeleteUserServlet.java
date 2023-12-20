package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.UserRepository;
import services.IUserService;
import services.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private final IUserService userService;

    public DeleteUserServlet() throws IOException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dni = req.getParameter("dni");
        Optional.ofNullable(dni).ifPresent(userService::deleteBy);

        resp.sendRedirect(req.getContextPath().concat("/list")); //redirect to /list(controller)...
    }
}
