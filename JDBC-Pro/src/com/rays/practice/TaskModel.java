package com.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaskModel {

	public int nextpk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from task");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

		}
		conn.close();
		return pk + 1;

	}

	public void add(TaskBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into task values(?, ? , ? , ? )");
		
		int pk = nextpk();

		pstmt.setInt(1, pk);
		pstmt.setDate(2, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(3, bean.getDetails());
		pstmt.setString(4, bean.getStatus());
	
	int i = pstmt.executeUpdate();
	System.out.println("Data Inserted Successfully: " + i);
	
	conn.close();
	}

}
