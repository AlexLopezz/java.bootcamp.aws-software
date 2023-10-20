package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.UserRepository;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    UserRepository userRepository;

    public DeleteUserServlet() throws IOException {
         userRepository = new UserRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> dni = Optional.ofNullable(req.getParameter("dni")); //We wrap the DNI parameter

        dni.ifPresent(d -> { //if the value is found
            try {

                userRepository.searchByDNI(d).ifPresent(u -> { //if the value found is from anything user... then
                    try {
                        userRepository.delete(u.getDni()); //delete by means your dni
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
