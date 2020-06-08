package com.voting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b4votingcheckdao {
	
	public boolean check(String oname, String uname) 
	{
//		String querry = "select * from polls where pollname=? and uname=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "123456789");
//		    PreparedStatement st = con.prepareStatement(querry);
//			st.setString(1, oname);
//			st.setString(2, uname);
//		    System.out.println("In b4votingcheckdao");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from polls where pollname='"+oname+"' and uname='"+uname+"'");
			rs.beforeFirst();
			rs.next();
			//String d1 = rs.getString("startdate");//+" "+rs.getString("starttime");
			//String d2 = rs.getString("enddate");//+" "+rs.getString("endtime");
			//System.out.println(d2);
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    Date d1 = sdformat.parse(rs.getString("startdate")+" "+rs.getString("starttime"));
		    Date d2 = sdformat.parse(rs.getString("enddate")+" "+rs.getString("endtime"));
		    Date date = new Date();
		    //System.out.println(d1);
		    //System.out.println(d2);
		    //System.out.println(date);
		    //if(rs.next())
			//{
				if(d1.compareTo(date)<0 && d2.compareTo(date)>0)
				{
		    	//if(d1.compareTo(d2)<0)
			//	{
		    		//System.out.println("true");
		    		return true;
				//}
					
				}
			//}
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
