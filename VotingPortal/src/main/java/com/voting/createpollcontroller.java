package com.voting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voting.dao.createpolldao;

@SuppressWarnings("serial")
public class createpollcontroller extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession(false);
		String uname = (String)session.getAttribute("uname");
		//System.out.println(uname);
		
		createpolldao dao = new createpolldao();		
		
		String pollname = request.getParameter("pollname");
		String startdate = request.getParameter("startdate");
		String starttime = request.getParameter("starttime");
		String enddate = request.getParameter("enddate");
		String endtime = request.getParameter("endtime");
		int numberofoptions = Integer.parseInt(request.getParameter("numberofoptions"));
		
		String options[]=new String[numberofoptions+1];
		
			for(int i=1;i<=numberofoptions;++i)
			{
				String s="option"+i;
				options[i-1]=request.getParameter(s);
				//System.out.println(options[i-1]);
			}
		
		if(dao.create(pollname, uname, startdate, starttime, enddate, endtime, numberofoptions, options)) 
		{
			response.sendRedirect("viewpollscontroller");//viewpollcontroller
		}
		else
		{
			response.sendRedirect("createpoll.jsp");
		}
		
	}

}
