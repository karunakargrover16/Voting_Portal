<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		body {
    background: #adad85;
	}
		div {
    width: 40%;
    margin-left: 27%;
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
<meta charset="UTF-8">
<title>Voting Portal</title>
</head>
<body>
<%
	response.setHeader("cache-control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxies
%>

	<div>
	<%
		String pname = (String)request.getAttribute("pname");
	%>
	<h2>Please enter the following details and select the option of your choice.
	We assure that the details you enter will be kept secured.</h2>
	
	<% 
		ArrayList<String> list = new ArrayList<String>();
		list = (ArrayList<String>)request.getAttribute("options");	
	%>
		<form action="aftervotingcontroller" method="post" autocomplete='off'>
		<input type="hidden" name=pname value=<%=pname %>><br>
		Enter your name: <input type="text" name=votername><br><br>
		Enter your email id: <input type="email" name=voteremail><br><br>
		
	<%	
		for(int i = 0; i < list.size(); i++) {
        	String name = list.get(i);
    %>
    	<input type="radio" name="answer" value="<%=name%>"><%=name%><br>
    <%
         };
    %>
    	<input type="submit" value="Submit">
		</form>  
	</div>
</body>
</html>