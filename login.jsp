<%@page import="java.util.*, java.io.*" %>
<%
String userName = request.getParameter("userName");
String password = request.getParameter("password");
Scanner cin = new Scanner(new File("userlist.txt"));
boolean find = false;
try{
	while(cin.hasNext()) {
		String[] up = cin.nextLine().split("\\s+");
		if(up[0].equals(userName) && up[1].equals(password)) {
			find = true;
		}
	}
}catch(Exception e){}

if(find) {
	session.setAttribute("name", userName);
	response.sendRedirect("index.jsp");
} else {
	response.sendRedirect("login.html");
}
%>