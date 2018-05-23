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
		<div id="options">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">Portfolio</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="Lines.html">Lines</a></li>
				<li><a href="point24.jsp">Point24</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
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
		<div align="middle" id="question">
			<h1>Have a Question ?</h1>
		</div>
		<form action="#">
			<input  name="search" id="searchPlace" placeholder="Type your search terms here">
			<input type="submit" id="searchButton" value="search">
		</form>
	</div>
	<div id="section">
		<div class="essay-title">
			<h2>London</h2>
		</div>
		<div class="essay-text">
			<div class="essay-text-word">
				<p>London, England. A capital city full of art and history. An important political centre. A huge financial market place.</p>
				<p>Whatever you think about London, visiting as a tourist is very different from living there. Each part of London has its own character.
					Some parts are richer than others, or more industrial, or have better housing. </p>
				<p>Let's start with the centre, the "Square Mile". This is the oldest part of London.
					In the past, this is where all financial business was done. Not many people live here, but 300,000 people work here every day.</p>
			</div>
			<div class="essay-text-ima">
				<img src="images/London.jpg" width="100%" height="100%">
			</div>
		</div>
		<div class="essay-command">
			<form action="#" method="post">
				<div>
					<input class="essay-command-inp" name="comment" placeholder="Enter Your Comment">
					<input class="essay-command-btn" type="submit" value="comment">
				</div>
			</form>
		</div>
		<div class="essay-title">
			<h2>New York</h2>
		</div>
		<div class="essay-text">
			<div class="essay-text-word">
				<p>London, England. A capital city full of art and history. An important political centre. A huge financial market place.</p>
				<p>Whatever you think about London, visiting as a tourist is very different from living there. Each part of London has its own character.
					Some parts are richer than others, or more industrial, or have better housing. </p>
				<p>Let's start with the centre, the "Square Mile". This is the oldest part of London.
					In the past, this is where all financial business was done. Not many people live here, but 300,000 people work here every day.</p>
			</div>
			<div class="essay-text-ima">
				<img src="images/NewYork.jpg" width="100%" height="100%">
			</div>
		</div>
		<div class="essay-command">
			<form action="#" method="post">
				<div>
					<input class="essay-command-inp" name="comment" placeholder="Enter Your Comment">
					<input class="essay-command-btn" type="submit" value="comment">
				</div>
			</form>
		</div>
	</div>
	<footer id="footer">
		<div>
			<p style="color: black">Copyright © World Traveling All Rights Reserved. </p>
		</div>
	</footer>		
</body>
</html>