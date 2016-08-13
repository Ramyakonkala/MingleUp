<!DOCTYPE html>
<html lang="en">
<head>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

 
<meta charset=utf-8 />
<title>JS Bin</title>
<style id="jsbin-css">
.like{
  border-radius:4px;
  text-align:center;
  display:inline-block;
  padding:3px 10px;
   
  background:white;
  cursor:pointer;
  box-shadow: 0 1px 1px -1px #666;
}
.userLikes{
  
  color:#5CB8E6;
}
 
  span.glyphicon-thumbs-up {
    font-size: 1.5em;
}</style>
</head>
<body>
       
  
  
<span class="like"><span class="glyphicon glyphicon-thumbs-up"></span></span>   

<script id="jsbin-javascript">


$('.like').click(function(){
  var val = $(this).text();
  $(this).toggleClass('userLikes');
  return $(this).hasClass('userLikes') ? like(this,val) : dislike(this,val);
});




</script>
</body>
</html>
