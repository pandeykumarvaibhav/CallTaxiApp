
let email = document.getElementById('email');
let pwd  = document.getElementById('pwd');

let email_fail = document.getElementById('email_fail');
let pwd_fail = document.getElementById('pwd_fail');

let form = document.getElementById('form');

form.addEventListener('submit', function(e)
{

 if(!email.value.includes("@"))
 {
   email_fail.innerText = "Enter valid email";
   email_fail.style.color = "red";
   e.preventDefault();
 }
 else
   email_fail.innerText = "";
 
 
  if(pwd.value.length === 0 || pwd.value === null)
  {
     pwd_fail.innerText = "password field should not be empty";
     pwd_fail.style.color = "red";
     e.preventDefault();
  }
  
  else
   pwd_fail.innerText = "";  
  
})