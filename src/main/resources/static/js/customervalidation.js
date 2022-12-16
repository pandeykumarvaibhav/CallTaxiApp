 
  let firstNameFail = document.getElementById('first_name_fail');
  let lastNameFail  = document.getElementById('last_name_fail');
  let emailFail = document.getElementById('email_fail');
  let phoneFail = document.getElementById('phone_fail');
  let pwdFail = document.getElementById('pwd_fail');  
 
  let form = document.getElementById('form'); 
   
 form.addEventListener('submit', function(e){
 
  let fName = document.getElementById('firstName');
  let lname = document.getElementById('lastName').value;
  let email = document.getElementById('email').value;
  let phone = document.getElementById('phone').value;
  let pwd   = document.getElementById('pwd').value;
  
 
  
  if(fName.value.length === 0 || fName.value === null){
    firstNameFail.innerText = "FirstName should not be empty";
    //firstName.style.border = "2px solid red";
    firstNameFail.style.color = 'red';
    e.preventDefault();
  }
  else
    firstNameFail.innerText = "";

  
    if(lname.length === 0 || lname === null){
    lastNameFail.innerText = "LastName should not be empty";
    lastNameFail.style.color = 'red';
    e.preventDefault();
  }
  else
    lastNameFail.innerText = "";

  
    if(email.length === 0 || email === null || !email.includes("@") ){
    emailFail.innerText = "invalid email";
    emailFail.style.color = 'red';
    e.preventDefault();
  }
  
  else
    emailFail.innerText = "";
  
  
    if(phone.length != 10 || phone === null){
    phoneFail.innerText = "Phone number size should be 10";
    phoneFail.style.color = 'red';
    e.preventDefault();
  }
  else
    phoneFail.innerText = "";
  
  
    if(pwd.length < 5 || pwd === null){
    pwdFail.innerText = "Password size should be atleast 5";
    pwdFail.style.color = 'red';
    e.preventDefault();
  }
  
  else
    pwdFail.innerText = "";  
    
  })
 