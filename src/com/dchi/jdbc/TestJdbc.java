package com.dchi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String user = "springstudent";
		String pass = "springstudent";
		try {
			System.out.println("Connecting to dB" + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Success!!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
