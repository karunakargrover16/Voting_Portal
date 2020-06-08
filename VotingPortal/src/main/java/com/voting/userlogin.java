package com.voting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voting.dao.logindao;

@SuppressWarnings("serial")
public class userlogin extends HttpServlet {
	
	logindao dao = new logindao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pswd = request.getParameter("pswd");
		
		if(dao.check(uname, pswd))
		{
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			response.sendRedirect("facts.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}

}

