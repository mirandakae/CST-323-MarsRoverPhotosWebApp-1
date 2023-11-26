//This script is trying to get a user ID from a URL parameter. If it can’t find one, it tries to get it from local storage. 
//If it still can’t find a user ID, it sets the value of an element with the ID ‘createUser’ to true. If a user ID is found, 
//it’s stored in local storage and the value of an element with the ID ‘userId’ is set to this user ID.
let userId = getUrlParameter('userId')
if (userId == null || userId == '') {
	userId = localStorage.getItem('userId')
	if (userId == null || userId == '') {
		document.getElementById('createUser').value = true
	} else {
		window.location.href = '/?userId='+userId
	}
}

if (userId != null && userId != '') {
	localStorage.setItem('userId', userId)
	document.getElementById('userId').value = userId
}


//Catching and getting button element by id "marsApi"
let marsApiButtons = document.querySelectorAll("button[id*='marsApi']")

$('.alert').alert()



//I am assigning a individual url on click function to know which rover is selected.
marsApiButtons.forEach(button => button.addEventListener('click', function() {
	const buttonId = this.id
	const roverId = buttonId.split('marsApi')[1]
	let apiData = document.getElementById('marsApiRoverData')
	apiData.value = roverId
	document.getElementById('frmRoverType').submit()
}))

//**I am getting querry string from the get element by id in the url. Reference: https://davidwalsh.name/query-string-javascript
//While URLSearchParams is ideal, not all browsers support that API. There's a polyfill available but if you want a tiny function 
//for basic query string parsing, the following is a function stolen from the A-Frame VR toolkit which parses the query string to 
//get the key's value:						  
function getUrlParameter(name) {
	name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
	var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
	var results = regex.exec(location.search);
	return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

let marsRoverType = document.getElementById('marsApiRoverData').value

highlightBtnByRoverType(marsRoverType)

//Get url paramter for Mars day (sol).
let marsSol = document.getElementById('marsSol').value
document.getElementById('marsSol').value = marsSol

//This function allows if the rovertype is blank in the querry string, Make Opportunity the default highlight.
function highlightBtnByRoverType(roverType) {
	if (roverType == '')
		roverType = 'Opportunity'
	//Remove basic secandary button when curent rovertype is selected. Change button to primary.	
	document.getElementById('marsApi' + roverType).classList.remove('btn-secondary')
	document.getElementById('marsApi' + roverType).classList.add('btn-primary')
}

function hideSpinner() {
	document.getElementById('spinner')
		.style.display = 'none';
} 