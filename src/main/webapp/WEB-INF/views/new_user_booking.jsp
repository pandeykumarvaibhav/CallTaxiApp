<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.cg.calltaxiapp.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booked User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
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
 button{
 font-weight: 600;
 margin-left:30%;
 padding : 5px;
 border-radius : 30%;
 }
</style>
<body>

<div class="container">
<h2>Booking Status</h2>
<h4>Customer name  :<span style="text-transform: uppercase"> ${user.firstName } ${user.lastName }</span> </h4>
<h4>Customer Phone : ${user.phoneNumber }</h4>
<form action="drivercancelbooking">
<input type = "hidden" name="userid" value="${user.custID }">
<input type = "hidden" name="driverid" value="${driverid }" />
<button type="submit">cancel booking</button>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>