<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>akForum</title>

	<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<header id="header">
		<h1>World Traveling</h1>
	</header>
	<nav id="nav" role="navigation">
			<div>
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="#">Portfolio</a></li>
					<li><a href="#">Services</a></li>
					<li><a href="Lines.html">Lines</a></li>
					<li><a href="point24.jsp">Point24</a></li>
					<li><a href="snake.html">Snake</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
	</nav>
	<div id="section">
		<form action="#" method="post">
			<div>
				<textarea name="comment" id="comment" cols="100" rows="10" placeholder="Enter Your Comment"></textarea><br>
				<input type="submit" value="comment">
			</div>
		</form>
		<h2>London</h2>
		<p>
			London is the capital city of England. It is the most populous city in the United Kingdom,
			with a metropolitan area of over 13 million inhabitants.
		</p>
		<p>
			Standing on the River Thames, London has been a major settlement for two millennia,
			its history going back to its founding by the Romans, who named it Londinium.
		</p>
		<p>
			London is the capital city of England. It is the most populous city in the United Kingdom,
			with a metropolitan area of over 13 million inhabitants.
		</p>
		<p>
			Standing on the River Thames, London has been a major settlement for two millennia,
			its history going back to its founding by the Romans, who named it Londinium.
		</p>
		<p>
			London is the capital city of England. It is the most populous city in the United Kingdom,
			with a metropolitan area of over 13 million inhabitants.
		</p>
		<p>
			Standing on the River Thames, London has been a major settlement for two millennia,
			its history going back to its founding by the Romans, who named it Londinium.
		</p>
		<p>
			London is the capital city of England. It is the most populous city in the United Kingdom,
			with a metropolitan area of over 13 million inhabitants.
		</p>
		<p>
			Standing on the River Thames, London has been a major settlement for two millennia,
			its history going back to its founding by the Romans, who named it Londinium.
		</p>
		<p>
			London is the capital city of England. It is the most populous city in the United Kingdom,
			with a metropolitan area of over 13 million inhabitants.
		</p>
		<p>
			Standing on the River Thames, London has been a major settlement for two millennia,
			its history going back to its founding by the Romans, who named it Londinium.
		</p>
		<p>
			London is the capital city of England. It is the most populous city in the United Kingdom,
			with a metropolitan area of over 13 million inhabitants.
		</p>
		<p>
			Standing on the River Thames, London has been a major settlement for two millennia,
			its history going back to its founding by the Romans, who named it Londinium.
		</p>
	</div>	
	<footer id="footer">
		<div>
			<%
			if(session.getAttribute("name") == null) {%>
				<p style="color: black">还没有登陆账号？点击<a href="login.html">登陆</a></p>
			<%}else {%>
				<p>尊敬的<%=session.getAttribute("name")%>,欢迎访问ak论坛<a href="logout.jsp">&nbsp注销</a></p>				
			<%}
			%>
		</div>
		<div>
			<p style="color: black">Copyright © akforum All Rights Reserved. </p>
		</div>
	</footer>		
</body>
</html>