package com.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"create table corporate(id int primary key, username varchar(50) , Email varchar(50) , password varchar(50))");
		i = stmt.executeUpdate("insert into corporate values (1 , 'with_lucly','Lucky@gmail.com ', '@1234') , (2 , 'bhuvi32', 'bhuvi@gmail.com' , '@fast') , (3 , 'ankit_rawat', 'ankit@gmail.com' , '@pubgstar')");
		System.out.println("Data Inserted Successfully" + "\t" + i);

		conn.close();

	}

}
