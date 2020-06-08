<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		div {
    width: 50%;
    margin-left: 22%;
    margin-top: 5%;
    padding: 3%;
    background: white;
    font-family: fantasy;
    border: 2px solid rgba(0,0,0,0.7);
    border-radius: 10px;
    font-size: 1.1em;
    allign: center;
}		
	</style>
<title>Voting Portal</title>
</head>
<body style="background-color: mediumpurple">
<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxies
%>

<br><br><br>
	<div>
	<center>
	<h3>Enter the following details to create an account.</h3><br>
	<form action="usersignup" method = "post" autocomplete='off'>
		Enter Username : <input type = "text" name ="uname"><br><br>
		Enter Password : <input type = "password" name ="pswd"><br><br>
		<input type ="submit" Value="SignUp">
	</form>
	</div>
	<center><br><h4>NOTE: Username has to be unique and must comprise of 6-20 characters(numbers and alphabets only).<br>
		  For a secure password use a combination of numbers, alphabets and special characters (#, @, $ etc).</h4></center>
</body>
</html>