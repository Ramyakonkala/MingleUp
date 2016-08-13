<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/bootstrap/bootstrap-3.3.4-dist/css/register.css"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>MingleUp Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="header">
		<h1>MingleUp</h1>
	</div>
	<div class="col-md-12">
		<div class="col-md-6">
			<div id="nav">
				<img src="./images/logo2.png" alt="logo" id="logo">
				<h2 id=h1>mingle, don't feel single</h2>
			</div>
		</div>
		<div class="col-md-6">
			<div id="section">
				<form action="LoginController">
					<table class="table">
						<caption>Login</caption>
						<tr>
							<td><b>Username:</b></td>
							<td><input type=text name="username" required></td>
						</tr>
						<tr>
							<td><b>Password:</b></td>
							<td><input type=password name="password" required></td>
						</tr>
						<tr>
							<td><button type="submit" class="btn2 btn-primary">Login</button></td>
							<td><a href="">Forgot your password?</a></td>
						</tr>
						<tr>
							<td colspan="2"><a href=signup.jsp>Are u new user? sign
									up here</a></td>
						</tr>
					</table>
					<%
						String user = request.getParameter("username");
						String error = request.getParameter("error");
						if (user == "") {
							out.print("<table align=center><tr><td><font color=red>*"
									+ "please enter username and password"
									+ "</font color></td></tr></table>");
						} else if (user != null) {
							out.print("<table align=center><tr><td><font color=red>*"
									+ " Please enter valid user name and password"
									+ "</font color></td></tr></table>");
						}
						if (error != null) {
							out.print("<table align=center><tr><td><font color=red>*"
									+ error + "</font color></td></tr></table>");
						}
					%>
				</form>
			</div>
		</div>

	</div>

	<footer id="footer">
		<p>Posted by: Uranus</p>
		<p>
			Contact information: <a href="">uranus@talentsprint.com</a>
		</p>
	</footer>
</body>
</html>
