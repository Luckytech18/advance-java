package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root" , "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("delete from cricket where id = 12 and 13");
		
		System.out.println("Database delete successfully " + i);
		
		conn.close();
	}

}
