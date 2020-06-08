package com.voting;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.voting.dao.aftervotingdao;
import com.voting.dao.verifyvoterdao;

@SuppressWarnings("serial")
public class aftervotingcontroller extends HttpServlet {
	
	aftervotingdao adao = new aftervotingdao();	
	verifyvoterdao vdao = new verifyvoterdao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String votername = request.getParameter("votername");
		String voteremail = request.getParameter("voteremail");
		String answer = request.getParameter("answer");
		String pname = request.getParameter("pname");
		
		if(vdao.verify(votername, voteremail, pname))
		{
		//System.out.println("In aftervotingcontroller");
			try {
				adao.submitvote(pname, answer);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("thanks.jsp");
	}

}
