<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		.navbar {
	margin-top: 2%;
    width: 96%;
    padding: 0.5%;
    background: rgba(0, 0, 0, 0.8);
    text-align: right;
    margin-left: 1%;
    overflow: auto;
	}
		div {
    width: 60%;
    margin-left: 17%;
    margin-top: 2%;
    padding: 3%;
    background: white;
    font-family: fantasy;
    border: 2px solid rgba(0,0,0,0.7);
    border-radius: 10px;
    font-size: 1.1em;
    allign: center;
	}
	</style>
<meta charset="UTF-8">
<title>Voting Portal</title>
</head>
<body bgcolor="AntiqueWhite">
<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxies
	if(session.getAttribute("uname")==null)
		response.sendRedirect("login.jsp");
%>
	<div class="navbar">
		<button onclick="location.href ='/VotingPortal/logout'">logout</button>
	</div>
<center><h2>Welcome! Create your poll here.</h2></center>
<div style="line-height:1.7">
<form action="createpoll" method="post" autocomplete='off'>
	Enter a name for poll/voting: <input type ="text" name ="pollname" required="required"><br>
	Enter poll/voting start date: <input type ="date" name="startdate" required="required"><br>
	Enter poll/voting start time: <input type ="time" name="starttime" required="required"><br>
	Enter poll/voting end date: <input type ="date" name="enddate" required="required"><br>
	Enter poll/voting end time: <input type ="time" name="endtime" required="required"><br>
	Enter number of voting options: <input type ="number" name ="numberofoptions" min="2" max="7"><br>
	Enter your options in the boxes below: <br>
	* <input type ="text" name="option1" required="required"><br>
	* <input type ="text" name="option2" required="required"><br>
	* <input type ="text" name="option3"><br>
	* <input type ="text" name="option4"><br>
	* <input type ="text" name="option5"><br>
	* <input type ="text" name="option6"><br>
	* <input type ="text" name="option7"><br>
	 <input type ="submit" value ="Create">  <input type= "reset">
</form>
	<b>NOTE: </b>Pollname has to be unique i.e. must not be used by you before this.<br>
	Combinaton if Start date and time must be greater than the current date.<br>
	Combination of End date and time must be greater than the combination of start date and time.<br>
	 The minimum options can be 2 and maximum options can be 7. <br>
	For efficient polling it is advised that if number of options to vote are more then
	one should conduct rounds of polling. For example: if there are 8 options two polls
	can be created to get two winners and then a final poll can be done to get the winner.
	Now this seems more fair and will attract more voters as well... <br>
</div>
</body>
</html>