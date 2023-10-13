package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import models.enums.GENDER;
import models.enums.PROFESSION;
import services.UserService;

import java.io.IOException;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserService userService = new UserService(session);



        User userToAdd = new User()
                .setDNI(Integer.parseInt(req.getParameter("dni")))
                .setName(req.getParameter("username"))
                .setLastName(req.getParameter("lastName"))
                .setGender(GENDER.valueOf(req.getParameter("gender")))
                .setProfession(PROFESSION.valueOf(req.getParameter("profession")));

        userService.save(userToAdd);

        resp.sendRedirect(req.getContextPath()+"/list");

        getServletContext()
                .getRequestDispatcher("/index.jsp").forward(req, resp);

    }


}
