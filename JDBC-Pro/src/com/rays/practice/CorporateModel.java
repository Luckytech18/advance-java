package com.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CorporateModel {

	// *Genrate Next Primary Key*//

	public int nextpk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from corporate");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		conn.close();
		return pk + 1;
	}

	// * Add A record ---//

	public void add(CorporateBean bean) throws Exception {
		
		CorporateBean existbean = findbylogin(bean.getEmail());
		if(existbean != null) {
			throw new Exception("Email id already exist");
		}

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into corporate values (? , ? , ? , ?)");
		int pk = nextpk();

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getUsername());
		pstmt.setString(3, bean.getEmail());
		pstmt.setString(4, bean.getPassword());

		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted Successfully:" + i);
		conn.close();
	}

	/* <---------(Delete a record)----------> */

	public void delete(CorporateBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from corporate where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data deleted Successfully" + i);

		conn.close();

	}
	/* <---------(Update a record)----------> */

	public void update(CorporateBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn
				.prepareStatement("update corporate set username = ? , email = ? , password = ? where id = ?");

		pstmt.setString(1, bean.getUsername());
		pstmt.setString(2, bean.getEmail());
		pstmt.setString(3, bean.getPassword());
		pstmt.setInt(4, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data Updated Successfully" + i);
		conn.close();

	}

	public CorporateBean findbylogin(String email) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from corporate where email = ?");

		pstmt.setString(1, email);

		ResultSet rs = pstmt.executeQuery();

		CorporateBean bean = null;

		while (rs.next()) {
			bean = new CorporateBean();

			bean.setId(rs.getInt(1));
			bean.setUsername(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));

		}
		conn.close();
		return bean;
	}

	/* <---------(Authenticate a record)----------> */

	public CorporateBean authenticate(String email, String Password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from corporate where email = ? and password = ?");

		pstmt.setString(1, email);
		pstmt.setString(2, Password);

		ResultSet rs  = pstmt.executeQuery();
		
		CorporateBean bean = null;
		while(rs.next()) {
			
			bean = new CorporateBean();
			
			bean.setId(rs.getInt(1));
			bean.setUsername(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
		}
		conn.close();
		return bean;

	}
	
	/* <---------(Authenticate a record)----------> */

	public void changePassword(String password , String NewPassword , String email) throws Exception {
		
		CorporateBean bean  = findbylogin(email);
		
		if(bean.getPassword().equals(password)) {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "root");
			PreparedStatement pstmt = conn.prepareStatement("update corporate set password = ? where id = ?");
			pstmt.setString(1, NewPassword);
			pstmt.setInt(2, bean.getId());
			
			int i = pstmt.executeUpdate();
			
			System.out.println("Password changed successfully");
			conn.close();
			}
		else {
			throw new Exception("Password error");
		}
		
	}
	
	public List search(CorporateBean bean) throws Exception {
		
		List list = new ArrayList();
		StringBuffer sfr = new StringBuffer("select * from corporate");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("sql ---->" + sfr.toString());
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "root");
		PreparedStatement pstmt = conn.prepareStatement(sfr.toString());
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			 bean = new CorporateBean();
			 bean.setId(rs.getInt(1));
			 bean.setUsername(rs.getString(2));
			 bean.setEmail(rs.getString(3));
			 bean.setPassword(rs.getString(4));
			 
			 list.add(bean);
	
		}
		conn.close();
		return list;

		
	}

}
