function validate() {


let username = document.getElementById("user");
let password = document.getElementById("pass");

if(username.value == "" || password.value == ""){
 alert("Must enter a username and password!")
 return false;
  }else{
      return true;
  }


}


function sendLogin() {
	console.log("sendLogin started.");
	let loginForm = document.loginForm;
	let username = document.getElementById("userbox").value;
	let password = document.getElementById("passbox").value;

	console.log(username + password);
	
	let loginTemplate = {
			username: username,
			password: password,
	};

	let xhr = new XMLHttpRequest();
     
	console.log(loginTemplate);
	
	console.log(xhr.status);
	
	xhr.onreadystatechange = function() {
		if(this.readyState === 4 && this.status === 200) {
			console.log(this.status);
			sessionStorage.setItem('currentUser', this.responseText);
			window.location = "http://localhost:8080/pOne/user/logpage.html";
		}
		
		if(this.readyState === 4 && this.status === 204) {
			alert("Failed to login! Username or password is incorrect.");
		}
		
		if(this.readyState === 4 && this.status === 418) {
			sessionStorage.setItem('currentUser', this.responseText);
			console.log(this.responseText);
			
			window.location = "http://localhost:8080/pOne/user/manager.html";
		}
	};

	xhr.open("POST", "http://localhost:8080/pOne/login");

	xhr.send(JSON.stringify(loginTemplate));
}


function sendRegister() {
	console.log("sendRegister started.");
	//let loginForm = document.loginForm;
	
	
	let firstname = document.getElementById("user10").value;
	let lastname = document.getElementById("user20").value;
	let username = document.getElementById("user3").value;
	let password = document.getElementById("pass").value;
	let email = document.getElementById("email2").value;
	

	console.log(username + password + firstname);
	
	let regTemplate = {
			firstname: firstname,
			lastname: lastname,
			username: username,
			password: password,
			email: email,
	
	};
	

	let xhr = new XMLHttpRequest();
     
	console.log(regTemplate);
	
	console.log(xhr.status);
	
	xhr.onreadystatechange = function() {
		if(this.readyState === 4 && this.status === 200) {
			console.log(this.status);
			sessionStorage.setItem('currentUser', this.responseText);
			window.location = "http://localhost:8080/pOne/user/logpage.html";
		}
		
		if(this.readyState === 4 && this.status === 204) {
			alert("Failed to login! Username or password is incorrect.");
		}
		
		if(this.readyState === 4 && this.status === 418) {
			sessionStorage.setItem('currentUser', this.responseText);
			console.log(this.responseText);
			
			window.location = "http://localhost:8080/pOne/user/manager.html";
		}
	};

	xhr.open("POST", "http://localhost:8080/pOne/register");

	xhr.send(JSON.stringify(regTemplate));
}
