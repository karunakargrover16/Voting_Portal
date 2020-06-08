package com.voting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class b4votingdao {
	
	public ArrayList<String> getOptions(String pname)
	{
		ArrayList<String> options = new ArrayList<String>();		
		try {
		    //System.out.println("In b4votingdao");			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "123456789");
			Statement st = con.createStatement();
			//System.out.println(pname);
			ResultSet rs = st.executeQuery("select optionname from "+pname);
			while(rs.next())
			{
				options.add(rs.getString("optionname"));
			}
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}

		return options;
	}
}