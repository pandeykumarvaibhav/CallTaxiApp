<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@page import="com.cg.calltaxiapp.entity.Driver"%>
<%@page import="com.cg.calltaxiapp.entity.Cab"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Drivers</title>
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
    left : 3%;
    top:-10%;
 
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

<h2 align="center" style="color : white">Registered Drivers</h2><br/>
<div class="container">
<table class="table table-dark table-striped table-bordered border-primary">

<tr>
<th>FirstName</th>
<th>lastName</th>
<th>Email</th>
<th>License</th>
<th>Aadhar</th>
<th>Phone</th>
<th>RegisteredDate</th>
<th>CabName</th>
<th>CabModel</th>
</tr>


  <%ArrayList<Driver> drivers = 
            (ArrayList<Driver>)request.getAttribute("drivers");
   ArrayList<Cab> cabs = (ArrayList<Cab>)request.getAttribute("cabs");
   
   for(int i=0; i<drivers.size() ;i++){%>
	   
	   <%Driver driver = drivers.get(i);
	     Cab  cab = cabs.get(i);
	   %>
	   
	  <tr>
	  <td><span><%=driver.getFirstName() %></span></td>
	  <td><span><%=driver.getLastName() %></span></td>
	  <td><%=driver.getEmail() %></td>
	  <td><%=driver.getLicenseNumber() %></td>
	  <td><%=driver.getAadharNumber() %></td>
	  <td><%=driver.getPhoneNumber() %></td>
	  <td><%=driver.getRegisteredDate() %></td>	 
	  <td><%=cab.getCabCompany() %></td>
	  <td><%=cab.getCabModel() %></td>	  
	  </tr>
   <%}
  %>

</table>
</div>
<a id="back" href="http://localhost:8080/calltaxi/verifiedadmin">Back</a><br />
<a id="home" href="http://localhost:8080/calltaxi/home">Home</a><br />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>