<%@page import = "com.mingleup.DAO.UserDAO.*" %>
<%@page import = "com.mingleup.models.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit profile</title>
</head>
<body>
 <jsp:include page="home.html"></jsp:include>

 
 <%
HttpSession hs = request.getSession();
String username = (String)hs.getAttribute("sname");
String email = request.getParameter("email");
String  DOB= request.getParameter("DOB");
String gender =  request.getParameter("gender");

UserBean cb = new UserBean();



%>
<div  class="col-md-6">
<form action= "EditProfileController">

<table align="center" class="table table-striped">
<thead>

<tr><th colspan="3" align="center"><h2>Edit Profile</h2></th></tr></thead>

<tr><td>username:</td><td><input type = "text" name = username  value = "<%=username%>" ></td></tr>
<tr><td>email:</td><td><input type = email name = email value = "<%=email%>"></td></tr>
<tr><td>Date Of Birth:</td><td><input type = text name = DOB value ="<%=DOB%>" ></td></tr>
<tr><td>gender:</td><td><input type = text name = gender value = "<%=gender%>"></td></tr>
<tr><td><input type = submit value = Update></td><td><a href="viewProfile.jsp"><input type = button value = back></a></td></tr>
</table>
</form>
</div><div  class="col-md-3"></div>
</body>
</html>