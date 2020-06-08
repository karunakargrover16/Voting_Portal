<%@page import="java.util.ArrayList"%>
<%@page import="com.voting.result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		body {
    background: #adad85;
	}
		.navbar {
    width: 96%;
    padding: 0.5%;
    margin-top: 1%;
    margin-left: 1%;
    background: rgba(0, 0, 0, 0.8);
    text-align: right;
    overflow: auto;
	}	
		div {
    width: 40%;
    margin-left: 27%;
    margin-top: 3%;
    padding: 2%;
    background: white;
    font-family: fantasy;
    border: 2px solid rgba(0,0,0,0.7);
    border-radius: 10px;
    font-size: 1.1em;
    allign: center;
	}		
		table {
	padding: 15px;
	border-width: 2px;
	border-style: solid;
	column-rule: 2px
	}
		th,td {
	border-bottom: 2px solid rgba(0,0,0,0.7);
	border-right: 2px solid rgba(0,0,0,0.7);
	padding-right: 15px;
	padding-left: 15px;	
	align: center;
	}
		.thtd-left {
	border-left: 2px solid rgba(0,0,0,0.7);
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
	if(session.getAttribute("uname")==null)
		response.sendRedirect("login.jsp");
%>
	<div class="navbar">
		<button onclick="location.href ='/VotingPortal/logout'">logout</button>
	</div>
	<div>
	<center><h2>Here are the results:-</h2></center>
	
	<% 
		ArrayList<result> list = new ArrayList<result>();
		list = (ArrayList<result>)request.getAttribute("pollresult");
	%>	
	<center><table>
        <thead>
            <tr>
                <th class="thtd-left">Option</th>
                <th>Votes </th>
            </tr>
        </thead>
        <tbody>
            <% 
            	for(int i = 0; i < list.size(); i++) {
                result r = new result();
                r = list.get(i);
            %>
            <tr>
                <td class="thtd-left"><%=r.getOptionname()%></td>
                <td><%=r.getVotes()%></td>
               </tr>
            <%
            	};
            %>
        </tbody>
    </table>
    </div>
</body>
</html>