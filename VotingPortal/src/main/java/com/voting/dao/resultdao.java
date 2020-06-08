package com.voting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.voting.result;

public class resultdao {
	
	public ArrayList<result> getResult(String pname)
	{
		ArrayList<result> pollresult = new ArrayList<result>();

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "123456789");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from "+pname);
			while(rs.next())
			{
				result r = new result();
				r.setOptionname(rs.getString("optionname"));
				r.setVotes(rs.getInt("votes"));
				pollresult.add(r);
			}
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return pollresult;
	}


}