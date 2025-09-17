package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// 1. Load Driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				// 2. Make connection to the database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "root" );

				// 3. Create Statement
				Statement stmt = conn.createStatement();

				// 4. Execute Query and get ResultSet
				int i = stmt.executeUpdate("insert into cricket values(12, 'raina', 'Batsman', 65, 75 , 90.00)");
				System.out.println("Data inserted successfully" +"/t" + i);
				
				conn.close();
				
	}

}
