package com.voting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class genlink extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
		String oname = request.getParameter("oname");
		String contextpath = "/VotingPortal/b4votingcontroller?";
		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextpath + "oname="+oname+"&uname="+uname;
		//System.out.println(baseUrl);
		
		
		request.setAttribute("baseUrl", baseUrl);
		RequestDispatcher rd = request.getRequestDispatcher("link.jsp");
		rd.forward(request, response);
	}
	
}
