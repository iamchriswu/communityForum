package wt.controller;

import wt.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SelfEvaluationServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String DB_USER =  getServletContext().getInitParameter("USER");
        String DB_PASS =  getServletContext().getInitParameter("PASS");
        String evaluationContent = new String(request.getParameter("selfEvaluation").getBytes("ISO-8859-1"),"UTF-8");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("name");
        UserDao userDao = new UserDao();
        if (UserDao.selfEvalustion(DB_USER, DB_PASS, userName, evaluationContent)) {
            response.sendRedirect("uHomePage.jsp");
        } else {
            response.sendRedirect("uHomePage.jsp");
        }
    }
}
