<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.mingleup.models.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.mingleup.DAO.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <%
	HttpSession hs = request.getSession();
	String username = (String) hs.getAttribute("sname");
	int user_id = (Integer) hs.getAttribute("suser_id");
	/* UserDAO userDAO = new UserDAO();
	List<UserBean> lst = userDAO.listContact(username);
	ListIterator<UserBean> lt = lst.listIterator(); */
%> 
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="all"
	href="./bootstrap/bootstrap-3.3.4-dist/css/styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Profile Page</title>
<%
	UserDAO ud = new UserDAO();
	String img = ud.getProfilePic(user_id);

	System.out.println(img + " this is img in Vprofile");
%>
</head>
<div class="well well-sm"
	style="background-color: #9932CC; width: 100%;">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><font id="head" color=white>MingleUp</font></a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a class="navbar-brand" href="Home"><font id="head"
						color=white><span data-toggle="tooltip" title="Home"
							class="glyphicon glyphicon-home"></span>Home</font></a></li>

				<li><a class="navbar-brand" href=""><font id="head"
						color=white><span class="glyphicon glyphicon-bell"></span>Notifications</font></a></li>

				<li><a class="navbar-brand" href="friendRequest.jsp"><font
						id="head" color=white><span class=""></span>Friend requests</font></a></li>
				<li><a class="navbar-brand" href="friendList.jsp"><font
						id="head" color=white><span class=""></span>Friend List</font></a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a class="navbar-brand" href=""><font id="head"
						color=white><span data-toggle="tooltip" title="Search"
							class="glyphicon glyphicon-search"></span>search</font></a></li>

				<li><a class="navbar-brand" href="LogoutController"><font
						id="head" color=white><span
							class="glyphicon glyphicon-log-out"></span> Logout</font></a></li>
			</ul>
		</div>
	</div>
</div>


<body style="background-color: #eeeeee;">


	<div class="col-md-2"></div>
	<div class="col-md-8">
	<div  style="position: relative; left: 0; top: 0;">
	<img src="./images/coverpic2.jpg" width="1000px" style="position:relative; top: 0; left: 0;"/>
  <img class="thumbnail" alt="dp" src=".<%=img%>" style="width:120px;height:120px; position:  absolute; top: 180px; left: 0px;"/> 
</div>
	
<%-- 	
	<img class="thumbnail" alt="dp" width="100"
					height="100" style="margin-top: 100px" src=".<%=img%>">
		<div id=wrapper style="width: 800px; height: 100%;" align="center">
			<img alt="coverpic" src="./images/default.jpg">
		</div> --%>
			
				<form method="post" action="ViewProfilePic"
						enctype="multipart/form-data">
						<input id="fileupload" type="file" name="img" /><input
							type="submit" value="Update">
					</form>

		<br>

		<div class=wrapper>
<!-- 

			<form>
				<div>
					<table align="center" class="table">



						<tr>

							<th>Name:</th>
						</tr>
						<tr>
							<th>Email:</th>
						</tr>
						<tr>
							<th>Date Of Birth:</th>
						</tr>
						<tr>
							<th>Gender:</th>
						</tr>
						<tr>
							<th>Update:</th>
						</tr>
					</table>
				</div>
			</form>
			<form> 
				<div class="col-md-3">
				<%-- 	<%
						while (lt.hasNext()) {
							UserBean cb = lt.next();
							out.print("<table align = center class = table table-stripped>");

							out.print("<tr>");
							out.print("<td>" + cb.getUser() + "</td>");
							out.print("</tr>");
							out.print("<tr>");
							out.print("<td>" + cb.getEmail() + "</td>");
							out.print("</tr>");
							out.print("<tr>");
							out.print("<td>" + cb.getDOB() + "</td>");
							out.print("</tr>");
							out.print("<tr>");
							out.print("<td>" + cb.getGender() + "</td>");
							out.print("</tr>");
							out.print("<tr>");
							out.print("<td><a href=editProfile.jsp?name="
									+ cb.getUser()
									+ "&email="
									+ cb.getEmail()
									+ "&DOB="
									+ cb.getDOB()
									+ "&gender="
									+ cb.getGender()
									+ "><img width = 30px height=30px alt=logo src=./images/update.png"
									+ "></a></td>");
							out.print("</tr>");
							out.print("</table>");
						}
					%> --%><table>
						<tr>
							<td align="center"><a href="Home"><input type=button
									value=back></a></td>
						</tr>
					</table>
				</div>-->
				<!-- <div class="col-md-4"></div>
			</form> -->
		</div>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %> 
 <c:forEach var = "item" items="${list}">
 <br><div></div>
 
<div id=wrapper style="width:520px; height: 100%;">
<div><a class=sgames href="viewProfile.jsp"><img align="left" class="img-circle" alt="userpic" src=".${item.dp}" width="30" height="30"><div align="left" >${item.username}</div></a><p style="font-style:italic;color: blue;" align="left">${item.dateTime}</p></div><br>
 
<p align="left">${item.comment}</p><br>
      <a href="<c:url value='${item.image}'/>" class="thumbnail">
            
 
 <img  style="width:300px;height:300px" src = "<c:url value='${item.image}'/>"/>
 </a>
    </div>
  
 </c:forEach>

	</div>

</body>
</html>