<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booked</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');

body {
 margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins',sans-serif;
  background: linear-gradient(#141e30, #243b55);
  min-height : 100vh;
 }
 
 #nodriver{
 position: absolute;
 top:50%;
 left:35%;
 color: #03e9f4; 
 }
 
 .container{
	width :  50%;  
    color: #03e9f4;
    margin-top : 20px;
    position:absolute;
    top:25%;
    left : 30%;
}
</style>
</head>
<body>

<div class="container">
<h2>Taxi Booked </h2>
<h2>Driver Name :&nbsp; ${driver.firstName } ${driver.lastName }</h2>
<h2>Driver Phone :&nbsp;${driver.phoneNumber } </h2>
</div>

</body>
</html>