package wt.controller;

import wt.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String DB_USER =  getServletContext().getInitParameter("USER");
        String DB_PASS =  getServletContext().getInitParameter("PASS");

        if (!password.equals(rePassword) || (userName.length() < 4) || (password.length() < 8)) {
            response.sendRedirect("register.html");
        } else {
            UserDao userDao = new UserDao();

            if (userDao.register(DB_USER, DB_PASS, userName, password)) {
                response.sendRedirect("login.html");
            } else {
                response.sendRedirect("register.html");
            }
        }


    }
}
