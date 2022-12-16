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
  min-height : 100vh;
 }
 
 #msg{
 position: absolute;
 top:40%;
 left:34%;
 color: #03e9f4; 
 font-size : 30px;
 font-weight: 900;
 letter-spacing: 3px;
 }

 
</style>
</head>
<body>
<h2 id="msg">${message }</h2>

</body>
</html>