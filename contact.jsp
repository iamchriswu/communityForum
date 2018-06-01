<%@ page import="wt.dao.CommandDao" %>
<%@ page import="wt.model.Command" %>
<%@ page import="java.util.Vector" %>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Us</title>

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
        <h2>Contact Us</h2>
    </div>
    <div class="essay-text">
    </div>
    <div class="contact">
        <h3>ADDRESS</h3>
        <p>AHSTU, ChuZhou, Anhui, China</p>
        <h3>TEL</h3>
        <p>+86 18855032030</p>
        <h3>MAIL</h3>
        <p>iamchriswu@weinan.gov.cn</p>
        <h3>WEBSITE</h3>
        <a href="http://oj.ahstu.cc">AHSTU ACM</a>
        <h3>BLOG</h3>
        <img src="images/weibo.jpg">
    </div>
</div>

<footer id="footer">
    <div>
        <p style="color: black">Copyright © World Traveling All Rights Reserved. </p>
    </div>
</footer>
</body>
</html>