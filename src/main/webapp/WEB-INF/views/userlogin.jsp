<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<body>

<div class="login-box">
<h2>User Login </h2>
<form action="verifyuser" method="post" id="form">

<div class="user-box">
 <input type = "text" name = "email" id="email" autocomplete="off"/> 
<label>Email</label>
<div class="fail" id="email_fail"></div>
</div>

<div class="user-box">
<input type = "text" name = "password" id = "pwd" autocomplete="off"/>
<label>Password</label>
<div class="fail" id="pwd_fail"></div>
</div>

<button id="submit" type = "submit">
Submit
</button>
<h4 class="new-user">New User ? <a href="register">Sign up</a></h4>
</form>
</div>
<br />
<a id="home" href="http://localhost:8080/calltaxi/home">Home</a>
<script src = "../js/loginvalidation.js"></script>
</body>
</html>