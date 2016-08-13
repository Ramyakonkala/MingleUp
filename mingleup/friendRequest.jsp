<%@page import="com.mingleup.DAO.FriendDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/bootstrap/bootstrap-3.3.4-dist/css/register.css"%>
    <%@page import="com.mingleup.DAO.*"%>
<%@page import="com.mingleup.models.*"%>

<%@ page import="java.util.*"%>
<%

HttpSession hs = request.getSession();
String user = (String)hs.getAttribute("sname");
int user_id = (Integer)hs.getAttribute("suser_id");
String query = "select username,user_id from users where user_id in (select friend_one from friends where status='0' and friend_two ="+user_id+")";
FriendDAO fdao = new FriendDAO();
List<SearchBean> req_list = fdao.listrequest(user_id,query); 

ListIterator<SearchBean> list  = req_list.listIterator();

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="shortcut icon" href="http://d15dxvojnvxp1x.cloudfront.net/assets/favicon.ico">
  <link rel="icon" href="http://d15dxvojnvxp1x.cloudfront.net/assets/favicon.ico">
  <link rel="stylesheet" type="text/css" media="all" href="./bootstrap/bootstrap-3.3.4-dist/css/styles.css">
  <link rel="stylesheet" type="text/css" media="all" href="./bootstrap/bootstrap-3.3.4-dist/css/import.css">
  <script type="text/javascript" src="./js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript" src="./js/jquery.tablesorter.min.js"></script>
	
</head>
<%
	UserDAO ud = new UserDAO();
	String img= ud.getProfilePic(user_id);

	System.out.println(img);
	%>
<div class="well well-sm" style="background-color: #9932CC;width: 100%;">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><font id="head" color=white>MingleUp</font></a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a class="navbar-brand" href="Home"><font id="head" color=white><span data-toggle="tooltip" title="Home"
							class="glyphicon glyphicon-home"></span>Home</font></a></li>

				<li><a class="navbar-brand" href=""><font id="head" color=white><span
							class="glyphicon glyphicon-bell"></span>Notifications</font></a></li>

				<li><a class="navbar-brand" href="friendRequest.jsp"><font id="head" color=white><span
							class=""></span>Friend requests</font></a></li>
				<li><a class="navbar-brand" href="friendList.jsp"><font id="head" color=white><span
						 	class=""></span>Friend List</font></a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a class="navbar-brand" href=""><font id="head" color=white><span data-toggle="tooltip" title="Search"
							class="glyphicon glyphicon-search"></span>search</font></a></li>
			
				<li><a class="navbar-brand" href="LogoutController"><font id="head" color=white><span
							class="glyphicon glyphicon-log-out"></span> Logout</font></a></li>
			</ul>
		</div>
	</div>
	</div>
	
	
<body style="background-color: #eeeeee;">


	
	<div class="col-sm-2">
		<div id=wrapper style="width:220px; height: 100px;">
		<div><img align="left" class="img-circle" alt="userpic" src=".<%=img%>" width="30" height="30"><a class=sgames href="viewProfile.jsp"><div align="left" ><%= user %></div></a></div><br>
		 <div><img align="left"  alt="profile" src="./images/editprofile.png" width="25" height="25"><a  href="viewProfile.jsp">Edit Profile</a></div><br><br>
		<div><img align="left"  alt="profile" src="./images/galleryicon.png" width="25" height="25"><a href="RetriveServlet">Gallery</a></div>
		</div><div ></div><br>
		<div id="wrapper" style="width:220px; height:180px;">
		<label class=sgames>Suggested Games</label><br>
		
		<div><img align="left" class="img-circle" alt="userpic" src="./images/Candy_Crush.png" width="30" height="30"><a href="https://king.com/#!/play/candycrush">Candy crush</a></div><br><br>
		<div><img align="left" class="img-circle" alt="userpic" src="./images/2048.png" width="30" height="30"><a href="http://2048game.com/">2048</a></div><br><br>
		<div><img align="left" class="img-circle" alt="userpic" src="./images/Subway_Surfers.png" width="30" height="30"><a href="http://k2t2.com/subway-surfers-online-game/">Subway surfers</a></div><br><br>
		 <div><img align="left" class="img-circle" alt="userpic" src="./images/kaiju.jpeg" width="30" height="30"><a href="http://www.a10.com/action-games/run-kaiju-run?fullscreen=true">run-kaiju-run</a></div><br>
		
		
	
	</div>
</div>
<div class= wrapper >
  <h2 class=h2>Friend requests</h2>
  
  <table id="keywords">
    <thead>
      <tr>
        <th><span id=head>Friends</span></th>
        <th colspan = 2><span id=head>Function</span></th>
        
      </tr>
    </thead>
<tbody>


<%
while(list.hasNext())
{
     SearchBean sb = list.next();
     out.print("<tr>");
     out.print("<td>"+sb.getFriendName()+"</td>");
    
    out.print("<td><a href='AcceptController?friendid="+sb.getFriendId()+"'><input type = button value=Accept></a></td>");
     
     
     out.print("<td><a href='RejectController?friendid="+sb.getFriendId()+"'><input type = button value=reject></a></td><br>");
     out.print("</tr>");
}

%>
</tbody>
</table>
</div> 
<script type="text/javascript">
$(function(){
  $('#keywords').tablesorter(); 
});
</script>


</body>
</html>