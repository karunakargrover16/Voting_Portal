<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		body {
    background: lightseagreen;
}
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
</head>
<title>
	Voting portal
</title>
<body style="background-color: lightslategray">
<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxies
%>

<br><br><br>
	<div>
<center>
	<h3>Please enter your credentials to login.</h3><br>
	<form action="userlogin" method="post" autocomplete='off'>
		Enter Username : <input type ="text" name ="uname"><br><br>
		Enter Password  : <input type ="password" name="pswd"><br><br>
		<input type ="submit" value = "LogIn">
	</form>
	</div>
	<center><h4>Not having an account? <button onclick="location.href ='/VotingPortal/signup.jsp'">SignUp</button> here.</h4>
</body>
</html>