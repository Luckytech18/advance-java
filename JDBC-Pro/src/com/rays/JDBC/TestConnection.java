package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class TestConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1.  load class
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		
		// 2. make connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "root");
		
	    //3. create statement
		Statement stmt = conn.createStatement();
		
		//4. Execute Query and get Resultset
		ResultSet rs = stmt.executeQuery("select * from cricket");
		
		while(rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t"+ rs.getDouble(6));
			
		}
		conn.close();
	}

}
