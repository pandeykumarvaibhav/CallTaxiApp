<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cab Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
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
 
 .container{
	width :  60%;
    background: rgba(0,0,0,.5);
   box-sizing: border-box;
   box-shadow: 0 15px 25px rgba(0,0,0,.6);
   border-radius: 10px;
    color: #03e9f4;
    margin-top : 12%;
    position : absolute;
    top:-10%;
    left : 17%;
  }

 a{
 text-decoration: none;
 color : black;
 padding : 7px;
 background : #03e9f4;
 text-align: center;
 }
 
 th{
 color : white;
 text-align: center;
 text-transform: uppercase;
 }
 td{
 color : #03e9f4; 
  text-align: center;
 
 }
 span{
 text-transform: capitalize;
 
 }
 #back{
 position : absolute;
 top:2%;
 left : 5%;
 width : 10%;
 }
 #home{
 position : absolute;
 top:2%;
 right : 5%; 
 width : 10%;
 }
</style>
</head>
<body>

<h2 align="center" style="color : white">CAB DETAILS</h2>

<div class="container">
<table style="width:50%;margin:auto" class="table table-dark table-striped table-bordered border-primary"  >
<tr>
<th>Cab Name</th>
<th>Cab Model</th>
</tr>

<c:forEach items="${cabs}" var ="cab" >
<tr>
<td><span>${cab.cabCompany}</span></td>
<td><span>${cab.cabModel}</span></td>
</tr>
</c:forEach>
</table>
</div>

<a id="back" href="http://localhost:8080/calltaxi/verifiedadmin">Back</a><br />
<a id="home" href="http://localhost:8080/calltaxi/home">Home</a><br />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>