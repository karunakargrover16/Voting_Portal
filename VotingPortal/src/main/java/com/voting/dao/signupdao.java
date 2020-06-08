package com.voting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class signupdao {

	String querry = "insert into userdata ( username, password) values (?, ?)";
	String url = "jdbc:mysql://localhost:3306/voting";
	String username = "root";
	String password = "123456789";
	public int insert(String uname, String pswd)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(querry);
			st.setString(1, uname);
			st.setString(2, pswd);
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Username already taken. Please try with another one");
			return 0;
		}
		return 1;

	}
}