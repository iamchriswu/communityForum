package wt.controller;

import wt.dao.UserDao;
import wt.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GBK");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String DB_USER =  getServletContext().getInitParameter("USER");
        String DB_PASS =  getServletContext().getInitParameter("PASS");

        UserDao userDao = new UserDao();
        User user = userDao.login(DB_USER, DB_PASS, userName, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("name",userName);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
