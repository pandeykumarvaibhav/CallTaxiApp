<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="../css/registration.css" type="text/css" />
<meta charset="ISO-8859-1">
<title>Customer Page</title>
</head>
<body>

<h2 class="mb-3">User Registration Form</h2>
<div class="container">
<form action = "saveuser" method = "post" id="form">

 <div class = "user"> 
 
 <div class="mb-3">
 <label for="firstName" class="form-label">FirstName</label> 
 <input id="firstName" placeholder="Enter first name" class="form-control" type = "text" name="firstName"/>
 <div id="first_name_fail"></div>
 </div>
 
 <div class="mb-3">
  <label for="lastName" class="form-label">LastName</label>  
<input class="form-control" placeholder="Enter last name" type = "text" id="lastName" name="lastName"/>
 <div id="last_name_fail"></div>
 </div>
 
 <div class="mb-3">
  <label for="email" class="form-label">Email</label> 
<input class="form-control" placeholder="Enter email id" type = "email" id="email" name="email"/>
 <div id="email_fail"></div>
 </div>
 
 <div class="mb-3">
 <label for="phoneNumber" class="form-label">PhoneNumber</label>  
<input type = "text" class="form-control" placeholder="Enter phone number" id="phone" name="phoneNumber" max="10" />
 <div id="phone_fail"></div>
 </div>
 
  <div class="mb-3">
   <label for="password" class="form-label">Password</label>  
 <input class="form-control" placeholder="Enter password" type = "password" id="pwd" name="password" />
 <div id="pwd_fail"></div>
 </div>
  
 <button id="submit" class="btn btn-block btn-primary" id="submitBtn" type = "submit">Submit</button>
 
 <button id="reset" class="btn btn-block btn-primary" type = "reset">Reset</button>
 
 </div>
</form>
</div>
<script type="text/javascript" src = "../js/customervalidation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>