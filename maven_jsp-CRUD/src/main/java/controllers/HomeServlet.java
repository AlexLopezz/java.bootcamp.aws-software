package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"", "/home", "/index"})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("headerPage", "Home - Page");
        req.setAttribute("title", "Welcome to my Maven JSP CRUD!");

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}