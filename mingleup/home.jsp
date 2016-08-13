<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.mingleup.DAO.*"%>
<%@page import="com.mingleup.models.*"%>
<%@page import="java.io.OutputStream"%>
<%@ page import="java.util.*"%>
<%@page import="com.mingleup.DAO.*"%>
<%@page import="java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	 <link rel="stylesheet" type="text/css" media="all" href="./bootstrap/bootstrap-3.3.4-dist/css/styles.css">
	<link rel="stylesheet" type="text/css" media="all" href="./bootstrap/bootstrap-3.3.4-dist/css/import.css">
<link href="Bootstrap/css/nav-custom2.css" rel="stylesheet" />
<script src="Bootstrap/js/bootstrap.js"></script>
<script src="Bootstrap/js/bootstrap.min.js"></script>
<script src="Bootstrap/js/bootstrap.npm.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
   <script src="https://code.jquery.com/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
   <script>$(document).ready(function () {
		(function($) {
			$('#filter').keyup(function () {
				var rex = new RegExp($(this).val(), 'i');
				$('.searchable tr').hide();
				$('.searchable tr').filter(function () {
					return rex.test($(this).text());
				}).show();
			})
		}(jQuery));
	});</script>
<style type="text/css">
body
{
    font-family: Arial;
    font-size: 10pt;
}
#dvPreview
{
    filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
    min-height: 400px;
    min-width: 400px;
    display: none;
}
</style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>

<title>Home</title>
<%
HttpSession hs=request.getSession();
int user_id = (Integer) hs.getAttribute("suser_id");
String user = (String)hs.getAttribute("sname");
UserDAO ud = new UserDAO();
String img= ud.getProfilePic(user_id);

System.out.println(img + "this is img");
%>
</head>


<div class="well well-sm">
<nav class="navbar navbar-inverse navbar-fixed-top" style="background-color: #9932CC;>
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
					<li><a class="navbar-brand" href="Timeline"><font id="head" color=white><img class=img-circle width=25 height=20 src=.<%=img %>><%=user%></font></a></li>
			<li><a class="navbar-brand" href="LogoutController?user_id=<%=user_id %>" ><font id="head" color=white><span
							class="glyphicon glyphicon-log-out"></span> Logout</font></a></li>
				</ul>
		</div>
	</div>
	</div>
	
</nav>	
	
<body style="background-color: #eeeeee;">


	
	<div class="col-sm-2 ">
		<div id=wrapper style="width:180px; height: 100%;">
		<div><a class=sgames href="Timeline"><img align="left" class="img-circle" alt="userpic" src=".<%=img%>" width="30" height="30"><div align="left" ><%= user %></div></a></div><br>
		 <div><img align="left"  alt="profile" src="./images/editprofile.png" width="25" height="25"><a  href="viewProfile.jsp">Edit Profile</a></div><br> <br>
		<div><img align="left"  alt="profile" src="./images/galleryicon.png" width="25" height="25"><a href="RetriveServlet">Gallery</a></div><br> 
		</div><div ></div><br>
		<div id="wrapper" style="width:180px; height: 100%;">
		<label class=sgames>Suggested Games</label><br>
		
		<div><a href="https://king.com/#!/play/candycrush"><img align="left" alt="userpic" class="img-circle" src="./images/Candy_Crush.png" width="25" height="25">Candy crush</a></div><br><br>
		<div><a href="http://2048game.com/"><img align="left" alt="userpic" src="./images/2048.png" class="img-circle" width="25" height="25">2048</a></div><br><br>
		<div><a href="http://k2t2.com/subway-surfers-online-game/"><img align="left" alt="userpic" class="img-circle" src="./images/Subway_Surfers.png" width="25" height="25">Subway surfers</a></div><br><br>
		 <div><a href="http://www.a10.com/action-games/run-kaiju-run?fullscreen=true"><img align="left" class="img-circle" alt="userpic" src="./images/kaiju.jpeg" width="25" height="25">run-kaiju-run</a></div><br><br>
		
		<!--a href="#" ></a> -->
	
	</div>
</div>

	<div class="col-sm-5">
		
	<%
	String alert = request.getParameter("alert");
	if (alert != null) {
		out.print(alert);
	}
	%>
	<script type="text/javascript">
  function PreviewImage() {
    var oFReader = new FileReader();
    oFReader.readAsDataURL(document.getElementById("fileupload").files[0]);

    oFReader.onload = function(oFREvent) {
      document.getElementById("uploadPreview").src = oFREvent.target.result;
    };
  };
</script>

			<form method="post" action="uploadServlet"
				enctype="multipart/form-data">
				<div id=wrapper style="width:500px; height: 100%;">
				<div><textarea class="form-control" rows="3" cols="50" name="comment" placeholder="Write something about this post"></textarea></div><div><img id="uploadPreview" style="width: 50px; height: 50px;" /></div>
				<div align="left"><input  id="fileupload" type="file" name="img" width="100" height="100" onchange="PreviewImage();"/></div><div align="right"><input type="submit" value="Post"></div>
				</div>
			
			</form>
<style id="jsbin-css">
.like{
  border-radius:4px;
  text-align:center;
  display:inline-block;
  padding:3px 10px;
   
  background:white;
  cursor:pointer;
  
}
.userLikes{
  
  color:#5CB8E6;
}
 
  span.glyphicon-thumbs-up {
    font-size: 1.8em;
}</style>			
		
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %> 
 <c:forEach var = "item" items="${list}">
 <br><div></div>
 
<div id=wrapper style="width:500px; height: 100%;">
<div><a class=sgames href="viewProfile.jsp"><img align="left" class="img-circle" alt="userpic" src=".${item.dp}" width="30" height="30"><div align="left" >${item.username}</div></a><p style="font-style:italic;color: blue;" align="left">${item.dateTime}</p></div><br>
 
<p align="left">${item.comment}</p><br>
       <a href="<c:url value='${item.image}'/>" class="thumbnail"> 
    
  
 
 <img  style="width:300px;height:300px"  src = "<c:url value='${item.image}'/>"/>
</a>
  
<span class="like"><span class="glyphicon glyphicon-thumbs-up"></span>Like</span>   


</div>
  
 </c:forEach>

 
<script id="jsbin-javascript">


$('.like').click(function(){
  var val = $(this).text();
  $(this).toggleClass('userLikes');
  return $(this).hasClass('userLikes') ? like(this,val) : dislike(this,val);
});




</script>



	</div>
	<div class="col-sm-3 " id="wrapper" style="width:250px; height: 100%;">
		
			<input placeholder="search friends" type=text id="filter"
				name="search"><button type="submit"
					class="glyphicon glyphicon-search"></button>

		<br>

		<%
		
			String msg = request.getParameter("msg");
			String msg2 = request.getParameter("msg2");
			if (msg != null) {
				out.print(msg);
			}
			if (msg2 != null) {
				out.print(msg2);
			}
		%>

	<h2 class=h2>Suggested Friends</h2>
<%

System.out.println(user_id+"user_id");

System.out.println("userdao call");
List<SuggestedBean> suggested = ud.SuggestedFriends(user_id);
System.out.println("calling method list getimg");
ListIterator<SuggestedBean> suggestedlist = suggested.listIterator();
System.out.println("iterator");
%><table class=table><%
while (suggestedlist.hasNext()) {
	
	SuggestedBean sb = suggestedlist.next();
	out.print("<form name='form1' action=FriendController?friendId="
							+ sb.getFriendId()
							+ "><tbody class=searchable><tr><td>"
							+ "<img width=30 height=30 class=img-circle src=."+sb.getDp()+" alt=dp>"+ sb.getName()
							+ "</td><td align=right><input type=hidden name = friendId value = "
							+ sb.getFriendId()
							+ ">"
							+ "<input type = submit value='send request' onClick='form1.SubmitButton.disabled=true;'></td></tr></tbody></form>");
	
}

%>
</table>
	</div>
	
	<div class="col-sm-2">
	<%
	String query = "select distinct username,up.user_id,dp from activefriends up, users where up.user_id in(select friend_one from friends where friend_two="+user_id+" and status='1' union select friend_two from friends where friend_one="+user_id+" and status='1') and up.user_id=users.user_id;";

	List<ActiveFriendBean> req_list = ud.activeFriends(user_id, query); 
	%><table class="table table-hover"><tr><th  colspan="2"><pre class=sgames>    Active Friends</pre></th></tr><%
			 System.out.println("hai");
	if(req_list!=null){
		 System.out.println("hello");
		ListIterator<ActiveFriendBean> list  = req_list.listIterator();
		 System.out.println("after lst");
		System.out.println("after afb");		 		 
		while(list.hasNext())
		{
			ActiveFriendBean afb = list.next();	
		 	 System.out.println(afb.getUsername());
		     out.print("<tr><td align=right><img class=img-circle src=."+afb.getDp()+" alt='dp' width=25px height=25px></td><td style='font-size:18px ' align=left>"+afb.getUsername()+"</td></tr>");			   
		}
	
		}
		else{
			 out.print("<tr><td colspan=2 align=right>No active friends</td></tr>");
		}
	%>
	</table>
	</div>

</body>
</html>