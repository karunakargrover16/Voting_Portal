package com.voting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voting.dao.signupdao;

@SuppressWarnings("serial")
public class usersignup extends HttpServlet {
	
	signupdao dao = new signupdao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pswd = request.getParameter("pswd");
		if(dao.insert(uname, pswd)==1)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			response.sendRedirect("signup.jsp");
		}
		
	}

}