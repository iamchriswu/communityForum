package wt.controller;

import wt.dao.CommandDao;
import wt.model.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandContent = new String(request.getParameter("comment").getBytes("ISO-8859-1"),"UTF-8");
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("name");
        String DB_USER =  getServletContext().getInitParameter("USER");
        String DB_PASS =  getServletContext().getInitParameter("PASS");

        if (userName == null || commandContent.length() < 8) {
            response.sendRedirect("index.jsp");
        } else {
            CommandDao commandDao = new CommandDao();
            Command command = commandDao.publish(DB_USER, DB_PASS, userName, commandContent);
            if (command != null) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        }
    }
}
