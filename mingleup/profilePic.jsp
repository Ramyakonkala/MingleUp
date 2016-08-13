<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" type="text/css" media="all" href="./bootstrap/bootstrap-3.3.4-dist/css/styles.css">
	<link rel="stylesheet" type="text/css" media="all" href="./bootstrap/bootstrap-3.3.4-dist/css/import.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
  function PreviewImage() {
    var oFReader = new FileReader();
    oFReader.readAsDataURL(document.getElementById("fileupload").files[0]);

    oFReader.onload = function(oFREvent) {
      document.getElementById("uploadPreview").src = oFREvent.target.result;
    };
  };
</script>
<body>
<div id=wrapper height=220px style="height: 220px;">
<h1 class=sgames>Set your profile pic</h1>
	<form method="post" action="ProfilePicController"
				enctype="multipart/form-data">
				
				<div  style="width:520px; height: 100%;">
				<img id="uploadPreview" style="width: 100px; height: 100px;" />
				<div align="left"><input  id="fileupload" type="file" name="img" width="100" height="100" onchange="PreviewImage();"/></div><div align="left"><input type="submit" value="Set Profile pic"></div>
				
				</div>
		</form>
		<a  href="welcome.jsp"><button>Skip</button></a>
		
		</div>
</body>
</html>