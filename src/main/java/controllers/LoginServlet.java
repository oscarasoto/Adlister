package controllers;

import daos.DaoFactory;
import daos.Users;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Users users = DaoFactory.userDao();

        User user = users.withUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            // show the login form again
            doGet(request, response);
            return;
        }

        // redirect to profile page
        response.sendRedirect("profile.jsp");
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
