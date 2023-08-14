package com.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectData {

	public static void main(String[] args) {

		try {
			//load the driver
			Class.forName("org.postgresql.Driver");
			
			//Creating connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/JdbcDemo", "postgres", "karan");
			
			//create a query
			String query = "select * from student";
			
			//create a preparedstatement
			Statement statement = con.createStatement();
			ResultSet set = statement.executeQuery(query);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String city = set.getString(3);
				
				System.out.println("Id: "+id);
				System.out.println("Student Name: "+name);
				System.out.println("Student City: "+city);
				System.out.println("-----------------------------");
			}
			
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
