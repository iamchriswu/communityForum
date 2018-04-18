<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>akForum</title>
</head>
<body>
	<div align="middle">
		<h1>Welcome</h1>
	</div>
	<div>
		<%
		if(session.getAttribute("name") == null) {%>
			<p>还没有登陆账号？点击<a href="login.html">登陆</a></p>
		<%}else {%>
			<p>尊敬的<%=session.getAttribute("name")%>,欢迎访问ak论坛</p>
		<%}
		%>
		
	</div>
	<div></div>
</body>
</html>