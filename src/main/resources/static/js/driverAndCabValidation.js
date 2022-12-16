
let firstNameFail = document.getElementById('fname_fail');
let lastNameFail = document.getElementById('lname_fail');
let email_fail = document.getElementById('email_fail');
let phone_fail = document.getElementById('phone_fail');
let pwd_fail = document.getElementById('pwd_fail');
let license_fail = document.getElementById('license_fail');
let aadhar_fail = document.getElementById('aadhar_fail');
let cab_name_fail = document.getElementById('cab_name_fail');
let cab_model_fail = document.getElementById('cab_model_fail');

let fname = document.getElementById('fname');
let lname = document.getElementById('lname');
let email = document.getElementById('email');
let phoneNo = document.getElementById('phoneNo');
let pwd = document.getElementById('pwd');
let licenseNo = document.getElementById('licenseNo');
let aadharNo = document.getElementById('aadharNo');
let cabCompany = document.getElementById('cabCompany');
let cabModel = document.getElementById('cabModel');

let form = document.getElementById('form');

form.addEventListener('submit', function(e){

if(isEmpty(fname.value)){
firstNameFail.innerText = "First Name should not be empty";
firstNameFail.style.color = 'red';
  e.preventDefault();
}
else
firstNameFail.innerText = "";


if(isEmpty(lname.value)){
lastNameFail.innerText = "Last Name should not be empty";
lastNameFail.style.color = 'red';
  e.preventDefault();
}
else
lastNameFail.innerText = "";

if(!(email.value.includes("@")) || isEmpty(email.value))
{
 email_fail.innerText = "Enter valid e-mail";
 email_fail.style.color = "red";
  e.preventDefault();
}
else
email_fail.innerText = "";

if(phoneNo.value.length != 10)
{
 phone_fail.innerText = "Enter valid phoneNumber";
 phone_fail.style.color = "red";
  e.preventDefault();
}
else
phone_fail.innerText = "";

if(pwd.value.length < 5){
 pwd_fail.innerText = "Password length should be atleast 5";
 pwd_fail.style.color = 'red';
  e.preventDefault();
}
else
pwd_fail.innerText = "";


if(licenseNo.value.length < 6){
 license_fail.innerText = "Enter valid license Number";
 license_fail.style.color = 'red';
  e.preventDefault();
}
else
license_fail.innerText = "";

if(aadharNo.value.length < 8){
aadhar_fail.innerText = "Enter valid aadhar Number";
aadhar_fail.style.color = 'red'
  e.preventDefault();
}
else
aadhar_fail.innerText = "";


if(isEmpty(cabCompany.value)){
 cab_name_fail.innerText = "cab name should not be empty";
 cab_name_fail.style.color = 'red';
  e.preventDefault();
}
else
cab_name_fail.innerText = "";
 

if(isEmpty(cabModel.value)){
  cab_model_fail.innerText = "cab model should not be empty";
  cab_model_fail.style.color = "red";
  e.preventDefault();
}

else
cab_model_fail.innerText = "";

})

function isEmpty(value){
  
  if(value === null || value.length === 0)
  return true;
  return false;
}

