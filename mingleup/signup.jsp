<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/bootstrap/bootstrap-3.3.4-dist/css/register.css"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Sign up to MingleUp</title>
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="docs/css/bootstrap.css">
 
<script type="text/javascript" src="docs/js/jquery.js"></script>
<script type="text/javascript" src="docs/js/bootstrap.js"></script>
<script type="text/javascript" src="password-score/dist/js/password-score.js"></script>
<script type="text/javascript" src="password-score/dist/js/password-score-options.js"></script>
<script type="text/javascript" src="dist/js/bootstrap-strength-meter.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script type="text/javascript">
    var datefield = document.createElement("input")
    datefield.setAttribute("type", "date")
    if (datefield.type != "date") {
        document
                .write('<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />\n')
        document
                .write('<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"><\/script>\n')
        document
                .write('<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"><\/script>\n')
    }
</script>
<script>
    if (datefield.type != "date") {
        jQuery(function($) {
            $('#date').datepicker({
                dateFormat : 'dd/mm/yy',
              //  maxDate : "+2d",
              //  minDate : "-0d"
            });
        })
    }
</script>

</head>


<body>

<div id="header"  class="col-md-12">
<div  class="col-md-6">
<h1>MingleUp</h1>
</div>
<div  class="col-md-6">
<form action="LoginController">
<table width ="300" align = "right">
<!-- <tr><td class = "text">User:</td><td class = "text">Password:</td></tr> -->
<!-- <tr><td><input type = hidden  name = "user_id" class="textbox"  required></td></tr> -->
<tr><td><input type = text  name = "username" placeholder="username" class="textbox"  required></td><td><input type = password placeholder="password" name = "password" class="textbox" required></td>
<td><button type="submit"   class="btn1 btn-block">Login</button></td></tr>
</table>
</form>
</div>
</div>


<div class="col-md-12">
<div class = "col-md-6">
<div id="nav">
<img src="./images/logo2.png" alt="logo" id="logo">
<h2 id=h1>mingle, don't  feel single</h2>
</div></div><div class = "col-md-6">
<div id="section">
<form action = "SignupController">
<div class="form-group">
<table  class="table">
<caption>Create your account</caption>
<tr><td><input type = text class = "form-control"class = "mytext" name = "username"  placeholder="Username" required></td></tr>
<tr><td><input type = password  class = "form-control" name = "password" class="mytext" placeholder="password" required></td></tr>

<tr><td><input type="email" class="form-control" name="email" placeholder="Email" data-error="Bruh, that email address is invalid" required></td></tr>
<tr><td><input type="DOB" class="form-control" name="DOB" placeholder="DOB"  id=date pattern="^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$" required></td></tr>

<tr><td><input type = "radio" name = "gender" value=male required>male &nbsp;<input type = "radio" name = "gender" value=female required>Female
<tr><td><button type="submit" class="btn btn-block">Sign Up</button></td></tr>

</table></div>
</form>
</div>
<%
String msg = request.getParameter("msg");
if(msg != null){
	out.print("<table align=center><tr><td><font color=red>*" +  msg + "</font color></td></tr></table>");
}
%>
 
</div>
</div>
 <footer id = "footer">
  <p>Posted by: Uranus</p>
  <p>Contact information: <a href="">uranus@talentsprint.com</a>.</p>
</footer>
</body>
</html>