/**
 * 
 */

function displaySubmitForm(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           document.getElementById("submitForm").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/project1/submitForm.html", true);
    xhttp.send(); 
}

function displayUserInfo(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           document.getElementById("viewProfile").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/project1/ReimbursementView", true);
    xhttp.send();
}

function hideUserInfo(){
	document.getElementById("viewProfile").innerHTML = '<button onclick = "displayUserInfo()">View Profile</button>';
}

function changeUserName(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           document.getElementById("viewProfile").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/project1/changeName.html", true);
    xhttp.send(); 
}

function changeUserEmail(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           document.getElementById("viewProfile").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/project1/changeEmail.html", true);
    xhttp.send(); 
}

function changeUserPassword(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           document.getElementById("viewProfile").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/project1/changePassword.html", true);
    xhttp.send(); 
}

function displayReimbursments(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           document.getElementById("viewReimbursments").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/project1/ReimbursementView", true);
    xhttp.send(); 
}

function displayEmployeeReimbursments(){
	var eID = document.getElementById("eID").value;
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           document.getElementById("viewReimbursments").innerHTML = this.responseText;
        }
    };
    xhttp.open("POST", "/project1/someReimbursments?eID="+eID, true);
    xhttp.send(eID); 
}

function displayAllReimbursments(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           document.getElementById("viewReimbursments").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/project1/allReimbursments", true);
    xhttp.send(); 
}

function displayAllEmployees(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
           document.getElementById("allEmployees").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "/project1/allEmployees", true);
    xhttp.send(); 	
}
