package wt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchContent = new String(request.getParameter("search").getBytes("ISO-8859-1"),"UTF-8");
        String realUrl = "https://cn.bing.com/search?q=" + searchContent;
        response.sendRedirect(realUrl);
    }
}
