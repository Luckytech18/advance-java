package com.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "root");
		
		Statement stmt = conn.createStatement();
		
		int i  = stmt.executeUpdate("insert into task values (1 , '18/01/2005', 'Gwalior' , 'active') ,(2 , '18/02/2006', 'Indore' , 'Inactive') ,(3 , '18/03/2007', 'Goa' , 'active') ,(4 , '18/04/2008', 'Delhi' , 'Inactive')") ;

		System.out.println("Data Inserted Successfully" +"\t" + i);
		
		conn.close();
	
	}

}
