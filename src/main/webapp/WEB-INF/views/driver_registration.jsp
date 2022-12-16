<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver Registration Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="../css/registration.css" />
</head>
<body>

<div class="container">
<form action="register" method="post" id="form">

<h2 class="mb-3">Driver Registration Form</h2>

<div class="driver">
<div class="mb-3">
<label for="firstName" class="form-label">FirstName</label>
<input type = "text"  class="form-control" name="firstName" id="fname" />
<div id="fname_fail"></div>
</div>

<div class="mb-3">
<label for="lastName" class="form-label">LastName</label>
<input type = "text"  class="form-control" name = "lastName" id="lname" />
<div id="lname_fail"></div>
</div>

<div class="mb-3">
<label for="email" class="form-label">Email</label>
<input type = "email"  class="form-control" name = "email" id="email" /> 
<div id="email_fail"></div>
</div>

<div class="mb-3">
<label for="phoneNumber" class="form-label">PhoneNumber</label>
<input type = "text"  class="form-control" name = "phoneNumber" id="phoneNo" max="10" />
<div id="phone_fail"></div>
</div>

<div class="mb-3">
<label for="password" class="form-label">Password</label>
<input type = "password"  class="form-control" name = "password" id="pwd" />
<div id="pwd_fail"></div>
</div>

<div class="mb-3">
<label for="licenseNumber" class="form-label">LicenseNumber</label>
<input type = "text"  class="form-control"  name = "licenseNumber" id="licenseNo" />
<div id="license_fail"></div>
</div>

<div class="mb-3">
<label for="aadharNumber" class="form-label">AadharNumber</label>
<input type = "text"  class="form-control" name = "aadharNumber" id="aadharNo" />
<div id="aadhar_fail"></div>
</div>
</div>

<h2 class="mb-3">Cab Registration Form</h2>
<div class="cab">
<div class="mb-3">
<label for="cabCompany" class="form-label">Cab Company</label>
<input  class="form-control" type = "text" name = "cabCompany" id="cabCompany" />
<div id="cab_name_fail"></div>
</div>

<div class="mb-3">
<label for="cabModel" class="form-label">Cab Model</label>
<input  class="form-control" type = "text" name = "cabModel" id="cabModel" />
<div id="cab_model_fail"></div>
</div>
</div>


<button  id="submit" class="btn btn-block btn-primary" type="submit">Submit</button>
<button  id="reset" class="btn btn-block btn-primary" type="reset">Reset</button>


</form>
</div>
<script type="text/javascript" src="../js/driverAndCabValidation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>