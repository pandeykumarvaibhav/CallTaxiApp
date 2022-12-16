<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver Login page</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="../css/driver_success_login.css" />
</head>
<body>

<h2>Welcome <span style="text-transform: uppercase">${driver.firstName} ${driver.lastName}</span></h2>
<div class="container">
<h4 id="h4">Your status</h4>

<% if((boolean)request.getAttribute("status")){%>
 <h4>Active</h4> 
 
 <form action="inactive">
<input type="hidden" name="field" value="${driver.driverID }"/>
<input type="hidden" name="msg" value="Inactive"/>
<button id="active" type="submit">Make InActive</button>
</form>

<h4>New Booking</h4>
<form action="newbooking">
<input type = "hidden" name = "driverid" value="${driver.driverID}"/>
<button id="booking" type="submit">see new booking</button>
</form>
<%}

else{%> <h4>Inactive</h4> 
<form action="active">
<input type="hidden" name="field" value="${driver.driverID }"/> 
<button id="inactive" type="submit">Make Active</button>
</form>

<%}
%>
</div>

<form action="driversummary">
<input type = "hidden" name="driverid" value="${driver.driverID }"/>
<button id="summary" type="submit">Show my summary</button>
</form>

<form action="inactive">
<input type="hidden" name="field" value="${driver.driverID }"/>
<input type="hidden" name="msg" value="Logout"/>
<button id="logout" type="submit">Logout</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>