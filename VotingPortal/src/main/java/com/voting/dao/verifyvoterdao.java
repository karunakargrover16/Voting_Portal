package com.voting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class verifyvoterdao {

	String querry = "insert into userdata ( username, password) values (?, ?)";
	public boolean verify(String name, String email, String pname)
	{
		String votertable = pname + "voters";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "123456789");
			Statement st = con.createStatement();
			st.executeUpdate("insert into "+votertable+" (votername, voteremail) values ('"+name+"', '"+email+"')");
		} 
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "You have already voted. ThankYou!");
			return false;
		}
		return true;
	}
	
}
