<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login success</title>
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
    position : absolute;
    top:-10%;
    left : 30%;
    display : flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}
h1{
color : white;
text-align: center;
margin-bottom:20px;
}
a{
text-decoration: none;
    color: black;
    font-weight: 600;
    background : #03e9f4;
    width : 100%;
    text-align: center;
    padding  :5px;
    letter-spacing: 2px;
}
#home{
position : absolute;
top :95%;
left : 10%;
width : 20%;
}
#logout{
position : absolute;
top :95%;
right : 10%;
width : 20%;
}

a:hover{
    color : #03e9f4;
    background: black;
}
</style>
</head>
<body>

<h1>Welcome ADMIN</h1>
<div class="container">
<a href = "registereduser">Registered User </a> <br /><br />
<a href = "newdriver">New Drivers</a> <br /><br />
<a href = "registereddriver">Registered Drivers </a><br /><br />
<a href = "driver/driverstatus">Driver Status</a><br /><br />
<a href = "cabs">Cab Details</a><br /><br />
<a href = "seeallbookings">see all bookings</a><br /><br />
<a id="home" href = "home">Home</a>
<a id="logout" href = "admin">Logout</a>
</div>
</body>
</html>