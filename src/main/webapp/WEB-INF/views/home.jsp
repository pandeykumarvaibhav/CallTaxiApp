<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<title>HomePage</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');

body{
padding : 0px;
margin : 0px;
}

#img{
width : 100vw;
height : 100vh;
background-image: url("images/car3.jpg");
background-size: cover;
}
#s{

font-size :30px;
width : 100%;
height : 20%;
display : flex;
justify-content : flex-end;
align-items : center;
flex-direction : row;
position: absolute;
background : rgba(0, 0, 0, 0.5);
}
a{
text-decoration : none;
 color : white;
 z-index : 1;
 margin:0 40px;
  padding : 5px;
   width : 10%;
   text-align: center;
  font-weight: 400;
}
a:hover{
 color : #03e9f4;
 background : black;

}
h3{
position : absolute;
top : 20%;
left : 20%;
font-size : 50px;
font-weight : 900;
text-transform: capitalize;
}
</style>
</head>
<body>

<!--
User user=(User)session.getAttribute("userRecord");



response.setHeader("Cache-Control","no-cache");

response.setHeader("Cache-Control","no-store");

response.setHeader("Pragma","no-cache");

response.setDateHeader ("Expires", 0);

if(session.getAttribute("userRecord")==null){

response.sendRedirect("/index.jsp");

}

-->
<div id="img">
<div id = "s">
 <a href="user/login">User</a>

 <a href="admin" >Admin</a>

 <a href="driver/login">Driver</a>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>