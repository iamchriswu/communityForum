package wt.controller;

import wt.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RewardServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String DB_USER =  getServletContext().getInitParameter("USER");
        String DB_PASS =  getServletContext().getInitParameter("PASS");
        HttpSession session = request.getSession();
        String rewardUser = (String) session.getAttribute("name");
        String rewardedUser = (String) session.getAttribute("rewardedUser");

        if (rewardUser == null || rewardedUser == null) {
            response.sendRedirect("index.jsp");
        } else if (rewardUser.equals(rewardedUser)) {
            response.sendRedirect("uHomePage.jsp");
        } else {
            UserDao userDao = new UserDao();
            if (userDao.reward(DB_USER, DB_PASS, rewardUser, rewardedUser)) {
                response.sendRedirect("oHomePage.jsp?uAccount=" + rewardedUser);
            } else {
                response.sendRedirect("oHomePage.jsp?uAccount=" + rewardedUser);
            }
        }
    }
}
