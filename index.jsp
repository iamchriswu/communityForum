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
		<div id="Home">
			<a href="index.jsp">World Traveling</a>
		</div>
		<div id="Login">
			<%
			if(session.getAttribute("name") == null) {%>
				<a href="login.html">Login</a></p>
			<%}else {%>
				<a href="logout.jsp"><%=session.getAttribute("name")%></a>			
			<%}
			%>
		</div>
	</header>
	<div id="search">
		<form action="#">
			<input type="text" name="search" id="searchPlace" placeholder="Search">
			<input type="submit" id="searchButton" value="search">
		</form>
	</div>
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
		<form action="#" method="post">
			<div>
				<textarea name="comment" id="comment" cols="150" rows="10" placeholder="Enter Your Comment"></textarea><br>
				<input type="submit" value="comment">
			</div>
		</form>
	</div>	
	<footer id="footer">
		<div>
			<p style="color: black">Copyright © World Traveling All Rights Reserved. </p>
		</div>
	</footer>		
</body>
</html>