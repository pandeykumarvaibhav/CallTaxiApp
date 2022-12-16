<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
body {
 margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins',sans-serif;
  background: linear-gradient(#141e30, #243b55);
  min-height : 70vh;
 }
 
  .container{
	width :  40%;
    background: rgba(0,0,0,.5);
   box-sizing: border-box;
   box-shadow: 0 15px 25px rgba(0,0,0,.6);
   border-radius: 10px;
    color: #03e9f4;
    margin-top : 12%;
}
h2{
color : white;
text-align: center;
margin-bottom:20px;
}
 h4{
 margin-bottom: 20px;
 }

</style>
</head>
<body>
<div class="container">
<h2>You can't ${message } </h2>
<h4>You have a booking </h4>
<h4><span style="text-transform: uppercase;">${user.firstName } ${user.lastName }</span></h4>
<h4>${user.phoneNumber }</h4>
</div>
</body>
</html>