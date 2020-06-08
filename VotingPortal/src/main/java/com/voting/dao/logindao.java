package com.voting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class logindao {

	String querry = "select * from userdata where username=? and password=?";
	String url = "jdbc:mysql://localhost:3306/voting";
	String username = "root";
	String password = "123456789";
	public boolean check(String uname, String pswd)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(querry);
			st.setString(1, uname);
			st.setString(2, pswd);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid credentials entered. Please retry with correct credentials.");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}