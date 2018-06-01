<%@ page import="wt.dao.CommandDao" %>
<%@ page import="wt.model.Command" %>
<%@ page import="java.util.Vector" %>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Result</title>

    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<header id="header">
    <div id="Home">
        <a href="index.jsp">World Traveling</a>
    </div>
    <div id="options">
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="Shanghai.jsp">Shanghai</a></li>
            <li><a href="London.jsp">London</a></li>
            <li><a href="Sydney.jsp">Sydney</a></li>
            <li><a href="LosAngeles.jsp">Los Angeles</a></li>
            <li><a href="contact.jsp">Contact</a></li>
        </ul>
    </div>
    <div id="Login">
        <%
            if(session.getAttribute("name") == null) {%>
        <a href="login.html">Login</a></p>
        <%}else {%>
        <a href="uHomePage.jsp"><%=session.getAttribute("name")%></a>
        <%}
        %>
    </div>
</header>
<div id="search">
    <div align="middle" id="question">
        <h1>Have a Question ?</h1>
    </div>
    <form action="result.jsp">
        <input  name="search" id="searchPlace" placeholder="Type your search terms here">
        <input type="submit" id="searchButton" value="search">
    </form>
</div>
<div id="section">
    <div class="essay-title">
        <h2>The Search Result</h2>
    </div>
    <div class="essay-text">
    </div>
</div>
<div class="command">

    <%
        String DB_USER = application.getInitParameter("USER");
        String DB_PASS = application.getInitParameter("PASS");
        String fuzzyQueryWords = request.getParameter("search");
        CommandDao commandDao = new CommandDao();
        Vector<Command> commands = commandDao.fuzzyQuery(DB_USER, DB_PASS, fuzzyQueryWords);
        int count = 1;
        for (Command command:commands
                ) {
            out.println("<div>");
            out.println("<div class=\"command-info-floor\">");
            out.println("<h3>#" + count + "</h3>");
            out.println("</div>");
            out.println("<div class=\"command-info\">");
            out.println("<div class=\"command-info-user\">");
            out.println("<a href=\"oHomePage.jsp?uAccount=" + command.getuAccount() + "\">" + command.getuAccount() + "</a>");
            out.println("<p>" + command.getuCommandTime() + " " + "(" + command.getuCommandFlag() + ")" +"</p>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"command-content\">");
            out.println("<p>" + command.getuCommandContent() + "</p>");
            out.println("</div>");
            out.println("</div>");
            count++;
        }
    %>
</div>

<footer id="footer">
    <div>
        <p style="color: black">Copyright © World Traveling All Rights Reserved. </p>
    </div>
</footer>
</body>
</html>