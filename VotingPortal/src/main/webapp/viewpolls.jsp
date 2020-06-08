<%@page import="java.util.ArrayList"%>
<%@page import="com.voting.viewpolls"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		body {
    background: silver;
	}
		.navbar {
    width: 96%;
    margin-top: 1%;
    margin-left: 1%;
    padding: 0.5%;
    background: rgba(0, 0, 0, 0.8);
    text-align: right;
    overflow: auto;
	}
		div {
    width: 60%;
    margin-left: 17%;
    margin-top: 3%;
    padding: 3%;
    padding-top: 1%;
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
	column-rule: 1px
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
		form {
	align: center;	
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
	<center><h2>Polls you created are listed below.</h2></center>
	
	<% 
		ArrayList<viewpolls> list = new ArrayList<viewpolls>();
		list = (ArrayList<viewpolls>)request.getAttribute("pollist");
	%>	
	<center><table cellspacing=0>
        <thead>
            <tr>
                <th class="thtd-left">Poll name</th>
                <th>Start date</th>
                <th>Start time</th>
                <th>End date</th>
                <th>End time </th>
            </tr>
        </thead>
        <tbody>
            <% 
            	for(int i = 0; i < list.size(); i++) {
                viewpolls vp = new viewpolls();
                vp = list.get(i);
            %>
            <tr>
                <td class="thtd-left"><%=vp.getPollname()%></td>
                <td><%=vp.getStartdate()%></td>
                <td><%=vp.getStarttime()%></td>
                <td><%=vp.getEnddate()%></td>
                <td><%=vp.getEndtime()%></td>
               </tr>
            <%
            	};
            %>
        </tbody>
    </table>
    </div><br><br>
    <center><form action="resultcontroller" method="get" autocomplete='off'>
	Enter a Pollname: <input type ="text" name ="oname"><br><br>
	<input type="hidden" name="uname" value="<%=session.getAttribute("uname")%>">
	<input type ="submit"  style="font-size: 20px" value="Get Results" >
	<input type ="submit"  style="font-size: 20px" formaction="genlink" value="Generate sharing url" >
	</form></center>
</body>
</html>