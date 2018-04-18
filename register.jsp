<%@page import="java.util.*, java.io.*"%>
<%
String userName = request.getParameter("userName");
String password = request.getParameter("password");
String rePassword = request.getParameter("rePassword");
Scanner cin = new Scanner(new File("userlist.txt"));
boolean find = false;
try{
	while(cin.hasNext()) {
		String[] up = cin.nextLine().split("\\s+");
		if(up[0].equals(userName)) {
			find = true;
			break;
		}
	}
}catch(Exception e){}
cin.close();
if(!password.equals(rePassword)) {
	response.sendRedirect("register.html");
} else if (find) {
	response.sendRedirect("register.html");
} else {
	PrintWriter write = new PrintWriter(new FileWriter("userlist.txt", true));
	write.println(userName + " " + password);
	response.sendRedirect("login.html");
	write.close();
}
%>