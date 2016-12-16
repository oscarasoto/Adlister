package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // TODO: make sure we find a user with that username
        // TODO: find a record in your database that matches the submitted password
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            // show the login form again
            doGet(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("/profile");
        }


//        // TODO: check the submitted password against what you have in your database
//        boolean validAttempt = false;
//
//        if (validAttempt) {
//            // TODO: store the logged in user object in the session, instead of just the username
//            request.getSession().setAttribute("user", username);
//            response.sendRedirect("/profile");
//        } else {
//            response.sendRedirect("/login");
//        }
    }
}
