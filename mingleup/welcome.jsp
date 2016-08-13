<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
<jsp:include page="home.html"></jsp:include>
	<%
		String msg = request.getParameter("msg");
		if (msg != null) {
			out.print("<br><font color=blue>" + msg + "</font color>");
		}
	%>
	<h1 class=sgames style="color: #FF00FF; font-size: 20px;">Welcome to mingle up! To mingle with your friends</h1>
</body>
</html>