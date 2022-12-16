let form = document.getElementById('form');

form.addEventListener('submit', function(e){

let selectSource = document.getElementById('source');
let selectDestination = document.getElementById('destination');

let src = selectSource.options[selectSource.selectedIndex].value;
let dest = selectDestination.options[selectDestination.selectedIndex].value;

if(src === "-------select-------")
{
e.preventDefault();
alert('select source');
}

else if(dest === "-------select-------"){
e.preventDefault();
alert('select Destination');
}

else if(src === dest){
e.preventDefault();
alert('source and destination should not be same');
}
});