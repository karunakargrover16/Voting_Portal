package com.voting.dao;

import com.voting.viewpolls;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class viewpollsdao {
	
	public ArrayList<viewpolls> view(String uname)
	{
		ArrayList<viewpolls> pollist = new ArrayList<viewpolls>();

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "123456789");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from polls where uname = '"+uname+"'");
			while(rs.next())
			{
				viewpolls vp = new viewpolls();
				vp.setPollname(rs.getString("pollname"));
				vp.setStartdate(rs.getString("startdate"));
				vp.setStarttime(rs.getString("starttime"));
				vp.setEnddate(rs.getString("enddate"));
				vp.setEndtime(rs.getString("endtime"));
				pollist.add(vp);
			}
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return pollist;
	}

}