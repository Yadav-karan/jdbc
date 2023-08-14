package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionDemo {

	public static void main(String[] args) {

		try {
			//load the driver
			Class.forName("org.postgresql.Driver");
			
			//Creating connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/JdbcDemo", "postgres", "karan");
			
			if(con.isClosed()) {
				System.out.println("Connection is closed");
			}else {
				System.out.println("Connection Created......");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
