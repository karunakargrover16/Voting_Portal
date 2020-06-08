<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		body {
    background: lightgreen;
}
		.navbar {
    width: 96%;
    padding: 0.5%;
    margin-left: 1%;
    background: rgba(0, 0, 0, 0.8);
    text-align: right;
    overflow: auto;
}
		.left-div {
    width: 30%;
    margin-left: 10%;
    margin-top: 3%;
    padding: 3%;
    height: 300px;
    background: white;
    font-family: fantasy;
    border: 2px solid rgba(0,0,0,0.7);
    border-radius: 10px;
    font-size: 1.1em;
    allign: center;
}
		.right-div {
    width: 30%;
    margin-left: 55%;
    margin-top: -380px;
    padding: 3%;
    height: 300px;
    background: white;
    font-family: fantasy;
    border: 2px solid rgba(0,0,0,0.7);
    border-radius: 10px;
    font-size: 1.1em;
    allign: center;
    position: relative;
}
	h3 {
	margin-top: 4%;
    font-family: fantasy;
    allign: center;
}
	</style>
<title>Voting Portal</title>
</head>
<body>
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
	<center><h3>You are good to go. Just click on <button onclick="location.href ='/VotingPortal/createpoll.jsp'">Create Poll</button></h3></center>
	<div class="left-div">
		<b>Here are some examples of what you can do using our portal...</b>
		<p>
			<b>Market and Political Research:</b> Gather opinions on new hot-button political issues,
			 products or service offerings.
		</p>
		<p>
			<b>Travel and Technology:</b> Shimla or Manali? iPhone or Android? Trains or Planes? Poll your friends/family
			 on what is their favorite.
		</p>
		<p>
			<b>Customer Service:</b> How would your customers rate their experience with your customer service team?
			 Did they wait long to get assistance? Find out with a quick poll.
		</p>
	</div>
	<div class ="right-div">
		<b>Quick tips to improve your polls...</b>
		<p>
			<b>Keep it short and simple:</b> Use a multiple choice format, with a maximum of two to five questions for quick polling.
		</p>
		<p>
			<b>Make it about them:</b> Use polls to encourage your audience’s engagement. 
			Ask for their opinions and preferences – and make it fun!
		</p>
		<p>
			<b>Introduce rounds:</b> Make rounds for different contests. Let people get excited about upcoming rounds.
		</p>
	</div>
	<center><h3>Already created polls? Just click on <button onclick="location.href ='/VotingPortal/viewpollscontroller'">View Polls</button></h3></center>
</body>
</html>