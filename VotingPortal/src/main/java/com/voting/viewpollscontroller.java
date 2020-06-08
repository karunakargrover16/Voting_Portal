package com.voting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voting.dao.viewpollsdao;

@SuppressWarnings({ "serial", "unused" })

public class viewpollscontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("uname");
		
		viewpollsdao dao = new viewpollsdao();
		ArrayList<viewpolls> pollist = new ArrayList<viewpolls>();
		pollist = dao.view(uname);
		
		request.setAttribute("pollist", pollist);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewpolls.jsp");
		rd.forward(request, response);
	}
	
}

