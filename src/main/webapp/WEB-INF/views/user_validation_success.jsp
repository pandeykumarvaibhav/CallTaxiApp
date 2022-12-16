<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="../css/usersuccesspage.css" />
</head>
<body>

<h2 class="mb-3">Welcome ${user.firstName} ${user.lastName }</h2>

<div class="userinfo">
<div><h3 style="text-align : center">My Info</h3></div>
<div><h4>Name    : <span style="text-transform: uppercase;">${user.firstName } ${user.lastName }</span></h4></div>
<div><h4>Email   : ${user.email }</h4></div>
<div><h4>Phone   : ${user.phoneNumber }</h4></div>
<div><h4>RegDate : ${user.registeredDate }</h4></div>
</div>

<form action="booking">
<input type="hidden" name = "userid" value = "${user.custID }"/>
<button id="book" type = "submit">Book a Taxi</button>
</form>

<form action="mybooking">
<input type="hidden" name = "userid" value = "${user.custID }"/>
<button id="mybooking" type = "submit">My Bookings</button>
</form>

<a id="home" href = "http://localhost:8080/calltaxi/home">Home</a>
<a id="logout" href = "login">Logout</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>