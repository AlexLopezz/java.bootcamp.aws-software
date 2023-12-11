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
        Optional<String> dni = Optional.ofNullable(req.getParameter("dni")); //We wrap the DNI parameter

        dni.ifPresent(d -> { //if the value is found
            try {

                userService.getBy(d).ifPresent(u -> { //if the value found is from anything user... then
                    try {
                        userService.deleteBy(u.getDni()); //delete by means your dni
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        resp.sendRedirect(req.getContextPath().concat("/list")); //redirect to /list(controller)...
    }
}
