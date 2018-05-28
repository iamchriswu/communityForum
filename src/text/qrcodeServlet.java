package text;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class qrcodeServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width =  Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        String format = request.getParameter("format");
        String content = request.getParameter("content");
        String name = request.getParameter("name");

        String path = new File(request.getRealPath("index.jsp")).getParent() + "\\" + name + "." + format;
        QrcodeModel.createQrcode(width, height, format, content, name, path);

        PrintWriter out = response.getWriter();
        out.println("<img src="+"\"" + path + "\"" +">");
    }
}
