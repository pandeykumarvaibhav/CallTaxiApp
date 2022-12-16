<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import = "com.cg.calltaxiapp.entity.Booking, com.cg.calltaxiapp.entity.User, 
 com.cg.calltaxiapp.entity.Driver, java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Booking</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="../css/mybooking.css" />
</head>
<body>


<h2 style="color : white; text-align: center">My Booking</h2>
<%List<Booking> bookings = (List<Booking>)request.getAttribute("bookings"); %>

<% for(int i=0 ;i<bookings.size() ; i++){%>

<%char status = bookings.get(i).getStatus(); Driver driver = bookings.get(i).getDriver(); User user = bookings.get(i).getUser();%>

<%if(status == 'b'){%> 

       <div class="container">
        <h5>Driver name  : <span style="text-transform: uppercase;"><%=driver.getFirstName() %> <%=driver.getLastName() %></span></h5>
        <h5>Driver Phone : <%=driver.getPhoneNumber() %></h5>
        <h5>Source       : <%=bookings.get(i).getSource() %></h5>
        <h5>Destination  : <%=bookings.get(i).getDestination() %></h5>
        <h5>Date         : <%=bookings.get(i).getBookedTimestamp().getMonth()%>
          <%=bookings.get(i).getBookedTimestamp().getDayOfMonth() %>
          <%=bookings.get(i).getBookedTimestamp().getYear() %></h5>
        <h5>Time         : <%=bookings.get(i).getBookedTimestamp().getHour() %>
        : <%=bookings.get(i).getBookedTimestamp().getMinute() %></h5>
        <h5>Status       : Booked</h5>
        <h5>Amount       : <%=bookings.get(i).getAmount() %></h5>
        <form action = "usercancelbooking">
	    <input type = "hidden" name="driverid" value=<%=driver.getDriverID() %> />
	    <input type = "hidden" name="userid" value="${userid}" />
	    <button type = "submit">cancel booking</button>
	    </form>
	    </div>

 <%}

else{%>
        <div class="container">
	    <h5>Driver name  :<span style="text-transform: uppercase;"><%=driver.getFirstName() %> <%=driver.getLastName() %></span></h5>
        <h5>Driver Phone : <%=driver.getPhoneNumber() %></h5>
        <h5>Source       : <%=bookings.get(i).getSource() %></h5>
        <h5>Destination  : <%=bookings.get(i).getDestination() %></h5>
        <h5>Date         : <%=bookings.get(i).getBookedTimestamp().getMonth()%>
          <%=bookings.get(i).getBookedTimestamp().getDayOfMonth() %>
          <%=bookings.get(i).getBookedTimestamp().getYear() %></h5>
        <h5>Time         : <%=bookings.get(i).getBookedTimestamp().getHour() %>
        : <%=bookings.get(i).getBookedTimestamp().getMinute() %></h5>
        <h5>Status       : Cancelled</h5>
       </div>
        
<%}
 %>   
       

 <%} %>
 

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>