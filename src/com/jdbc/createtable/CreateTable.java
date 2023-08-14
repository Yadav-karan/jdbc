package com.jdbc.createtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {

		try {
			//load the driver
			Class.forName("org.postgresql.Driver");
			
			//Creating connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/JdbcDemo", "postgres", "karan");
			
			//create a query
			String query = "CREATE TABLE STUDENT(\r\n"
					+ "   ID INT PRIMARY KEY      NOT NULL,\r\n"
					+ "   S_NAME           CHAR(50) NOT NULL,\r\n"
					+ "   CITY         CHAR(200)      NOT NULL\r\n"
					+ ");";
			
			//create a statement
			Statement st = con.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Table created");
			
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
