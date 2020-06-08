package com.voting;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voting.dao.b4votingcheckdao;
import com.voting.dao.b4votingdao;

@SuppressWarnings("serial")
public class b4votingcontroller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//HttpSession session = request.getSession();
		//String uname = (String)session.getAttribute("uname");
		
		String uname = request.getParameter("uname");
		
		String oname = request.getParameter("oname");
		String pname = oname+uname;
		//System.out.println("In b4votingcontroller");
		
		b4votingcheckdao bdao = new b4votingcheckdao();
		if(bdao.check(oname, uname))
		{
			b4votingdao dao = new b4votingdao();
			ArrayList<String> options = new ArrayList<String>();
			options = dao.getOptions(pname);
			request.setAttribute("options", options);
			request.setAttribute("pname", pname);
			
			RequestDispatcher rd = request.getRequestDispatcher("vote.jsp");
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("votingclose.jsp");
		}
		
	}
}