
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.mingleup.DAO.*"%>
<%@page import="com.mingleup.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="./bootstrap/bootstrap-3.3.4-dist/css/styles.css">
<title>Insert title here</title>
</head>
<body style="background-color: #eeeeee">
<jsp:include page="links.jsp"></jsp:include>
<div class="container">
  <h2>My Gallery</h2>            
  <div class="row">
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %> 
 <c:forEach var = "item" items="${list}">
<div class="col-md-3">
      <a href="<c:url value='${item.image}'/>" class="thumbnail">
        <p>${item.comment}</p>    
     
 
 <img style="width:150px;height:150px" src = "<c:url value='${item.image}'/>"/>
 </a>
    </div>
  
 </c:forEach>

 </div>
 
</div>

</body>
</html>