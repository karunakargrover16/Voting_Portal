package com.voting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class aftervotingdao {

	public void submitvote(String pname, String ans) throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "123456789");
			Statement st = con.createStatement();
			st.executeUpdate("update "+pname+" set votes = votes + 1 where optionname = '"+ans+"'");
			//System.out.println("In aftervotingdao");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
