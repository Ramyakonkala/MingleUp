<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
     <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
        <div class="navbar-header">
          <a class="brand" href="#"><b>Online Examination</b></a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href = adminhome.jsp><b>Home</b></a></li>
              <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><b>Courses</b><span class="caret"></span></a>
          	<ul class="dropdown-menu">
            <li><a href = "course.jsp">Add course</a></li>
            <li><a href = "index.jsp">List Courses</a></li>
          </ul>
        </li>
        </ul>
        <div id = "a">
             <ul class="nav navbar-nav navbar-right">
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><b>Welcome!! Admin</b><span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href = mainhome.jsp>SignOut</a></li>
            </ul>
            </li>
      </ul>
      </div>
          </div>
          </div>
        </div>
      </div>
    </div>
    </nav>
</body>
</html>