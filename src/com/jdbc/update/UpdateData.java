package com.jdbc.update;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData {
	
	public static void main(String[] args) {
		try {
			//load the driver
			Class.forName("org.postgresql.Driver");
			
			//Creating connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/JdbcDemo", "postgres", "karan");
			
			//create a query
			String query = "update student set s_name=?,city=? where id=?";
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter new name");
			String name = br.readLine();
			
			System.out.println("Enter new city");
			String city = br.readLine();
			
			System.out.println("Enter student id");
			int id = Integer.parseInt(br.readLine());
			
			//create a preparedstatement
			PreparedStatement ps = con.prepareStatement(query);
			
			//set values
			ps.setString(1, name);
			ps.setString(2, city);
			ps.setInt(3, id);
			
			ps.executeUpdate();
			System.out.println("Record inserted.......");
			
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
