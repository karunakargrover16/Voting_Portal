package com.voting;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voting.dao.resultdao;

@SuppressWarnings("serial")
public class resultcontroller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("uname");
		
		String pname = request.getParameter("oname");
//		System.out.println(pname);
		pname=pname+uname;
//		System.out.println(pname);

		resultdao dao = new resultdao();
		ArrayList<result> pollresult = new ArrayList<result>();
		pollresult = dao.getResult(pname);
		
		request.setAttribute("pollresult", pollresult);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewresult.jsp");
		rd.forward(request, response);
		
	}

}