package com.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {

	public static void main(String[] args) {

		try {
			//load the driver
			Class.forName("org.postgresql.Driver");
			
			//Creating connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/JdbcDemo", "postgres", "karan");
			
			//create a query
			String query = "INSERT INTO student(id,s_name,city) values(?,?,?)";
			
			//create a preparedstatement
			PreparedStatement ps = con.prepareStatement(query);
			
			//set values
			ps.setInt(1,101);
			ps.setString(2, "Karan");
			ps.setString(3, "NSP"); 
			
			ps.executeUpdate();
			System.out.println("Record inserted.......");
			
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
