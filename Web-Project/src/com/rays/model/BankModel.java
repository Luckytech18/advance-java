package com.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.BankBean;
import com.rays.bean.UserBean;
import com.rays.exception.DuplicateRecordException;
import com.rays.exception.RecordNotFoundException;
import com.rays.utill.JDBCDataSource;

public class BankModel {

	/* <---------Generate next primary key----------> */
	public int nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_bank");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id: " + pk);
		}

		conn.close();
		return pk + 1;

	}

	/* <---------insert a record----------> */
	public void add(BankBean bean) throws Exception {

		

		

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_bank values(?, ?, ?, ?, ?)");

		

		pstmt.setString(1, bean.getAccountNo());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getAccType());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();

		System.out.println("data inserted successfully: " + i);
		conn.close();
	}

	/* <---------delete a record----------> */
	public void delete(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_bank where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("data deleted successfully: " + i);
		conn.close();

	}

	/* <---------update a record----------> */
	public void update(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_bank set firstName = ?, lastName = ?, login = ?, password = ?, dob = ? where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getdob().getTime()));
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("data updated successfully: " + i);
		conn.close();

	}

	/* <---------record find by login----------> */
	public UserBean findByLogin(String login) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_bank where login = ?");

		pstmt.setString(1, login);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setdob(rs.getDate(6));

		}

		conn.close();
		return bean;

	}

	/* <---------authenticate user----------> */
	public UserBean authenticate(String login, String password) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_bank where login = ? and password = ?");

		pstmt.setString(1, login);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setdob(rs.getDate(6));

		}

		conn.close();
		return bean;

	}

	/* <---------change password----------> */
	public void changePassword(String oldPassword, String newPassword, String login) throws Exception {

		UserBean existBean = findByLogin(login);

		if (existBean == null) {
			throw new RecordNotFoundException("User not found");
		}

		System.out.println("database password: " + existBean.getPassword());
		System.out.println("oldPassword: " + oldPassword);

		if (existBean.getPassword().equals(oldPassword)) {

			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update st_bank set password = ? where login = ?");

			pstmt.setString(1, newPassword);
			pstmt.setString(2, login);

			int i = pstmt.executeUpdate();
			System.out.println("password has been changed: " + i);
			conn.close();

		} else {
			throw new Exception("old password is incorrect");
		}

	}

	public UserBean findById(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_bank where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setdob(rs.getDate(6));

		}

		conn.close();
		return bean;

	}

	public List search(BankBean bean, int pageNo, int pageSize) throws Exception {

		List list = new ArrayList();

		StringBuffer sql = new StringBuffer("select * from st_bank where 1 = 1");

		if (bean != null) {
			
			if (bean.getAccountNo() != null && bean.getAccountNo().length() > 0) {
				sql.append(" and firstName like '" + bean.getAccountNo() + "%'");
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastName() + "%'");
			}
			
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				Date dob = new Date(bean.getDob().getTime());
				sql.append(" and dob like'" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		Connection conn = JDBCDataSource.getConnection();
		System.out.println("sql ----> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new BankBean();
			bean.setAccountNo(rs.getString(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setAccType(rs.getString(4));
			bean.setDob(rs.getDate(5));
			list.add(bean);

		}

		conn.close();
		return list;

	}

}