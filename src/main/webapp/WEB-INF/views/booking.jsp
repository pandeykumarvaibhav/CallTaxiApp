<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
  <%@page import="java.util.List, java.util.ArrayList, 
   com.cg.calltaxiapp.entity.Driver,
   com.cg.calltaxiapp.entity.Cab" %> 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="../css/booking.css" />
</head>
<body>

<%
ArrayList<Driver> drivers = (ArrayList<Driver>)request.getAttribute("drivers"); 
ArrayList<Cab> cabs = (ArrayList<Cab>)request.getAttribute("cabs");
%>

<%
 if(drivers.isEmpty()){%><h2 id="nodriver"> No taxi's available, comeback after some time </h2><%}
 for(int i=0 ;i<drivers.size() ; i++){%>
 
 <%  Driver driver = drivers.get(i);
   Cab cab = cabs.get(i); %> 
  <div class="container">
  <form action = "book" method="post" id="form">
  <div class="driver-info">
  <h5>DriverName&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;<span style="text-transform: uppercase;"><%=driver.getFirstName()%></span></h5>
  <h5>DriverPhone &nbsp;:&nbsp;&nbsp;<%=driver.getPhoneNumber() %></h5>
  <h5>Cab &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;<%=cab.getCabCompany() %></h5>
  <h5>Cab Model  &nbsp;&nbsp;&nbsp;       :&nbsp;&nbsp; <%=cab.getCabCompany() %></h5>
  <h5>Select source    </h5><select id="source" name="source">
  <option>-------select-------</option>
  <option value="chennai">chennai</option>
  <option value="salem">salem</option>
  <option value="erode">Erode</option>
  <option value="trichy">Trichy</option>
  </select>
  <h5>Select Destination </h5><select id="destination" name="destination">
  <option>-------select-------</option>
  <option value="chennai">chennai</option>
  <option value="salem">salem</option>
  <option value="erode">Erode</option>
  <option value="trichy">Trichy</option>
  </select>
  <input type = "hidden" name="driverId" value=<%=driver.getDriverID() %> />
  <input type = "hidden" name="userId" value="${userid }" />
  <button type = "submit" >Book</button>
  </div>
  </form>
  </div>
<%}%>


<script src="../js/bookingvalidation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>