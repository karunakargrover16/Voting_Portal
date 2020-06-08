package com.voting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class createpolldao {

	private String checkpollquerry = "select * from polls where pollname=? and uname=?";
	private String querry = "insert into polls ( pollname, uname, startdate, starttime, enddate, endtime, numberofoptions) values (?, ?, ?, ?, ?, ?, ?)";
	private String url = "jdbc:mysql://localhost:3306/voting";
	private String username = "root";
	private String password = "123456789";
	public boolean create(String pollname, String uname, String startdate,String starttime, String enddate, String endtime, int n, String options[] )
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);			
			PreparedStatement ps1 = con.prepareStatement(checkpollquerry);
			ps1.setString(1, pollname);
			ps1.setString(2, uname);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) {
				JOptionPane.showMessageDialog(null, "A table from this name already exixts. Please choose another name.");
				return false;
			}
			
			PreparedStatement st = con.prepareStatement(querry);
			st.setString(1, pollname);
			st.setString(2, uname);
			st.setString(3, startdate);
			st.setString(4,  starttime);
			st.setString(5, enddate);
			st.setString(6,  endtime);
			st.setInt(7, n);
			st.executeUpdate();
			
			String voters = "voters";
			String tablename = pollname+uname;
			String voterstable = tablename+voters;
			Statement ps2 = con.createStatement();
			ps2.executeUpdate("create table "+tablename+"( optionname varchar(50), votes int)");
			ps2.executeUpdate("create table "+voterstable+"( votername varchar(50), voteremail varchar(50) UNIQUE)");
			int num=0;
			
			for(int i=0;i<n;i++) {
//				System.out.println(options[i]);
				Statement s = con.createStatement();
				s.executeUpdate("insert into "+tablename+"(optionname, votes) values ('"+options[i]+"', "+num+")");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}