package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:postgresql://localhost:5432/new";
		String user = "postgres";
		String pass = "postgres";
		try {
			System.out.println("Connecting to DB"+jdbcURL);
		Connection con = DriverManager.getConnection(jdbcURL, user, pass);
		System.out.println("Connection Successfull");
		}  catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
