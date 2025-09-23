package com.rays.preparedStatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testdelete();
		// testupdate();
		// testfindbylogin();
//		testAuthenticate();
		//testchangePassword();
		testsearch();

	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setFirstName("Lucky");
		bean.setLastName("Tomar");
		bean.setLogin("Luckytomar@gmail.com");
		bean.setPassword("123456");
		bean.setDate(sdf.parse("2005-18-01"));

		model.add(bean);

	}
// delete a record

	public static void testdelete() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(1);

		model.delete(bean);
	}

	public static void testupdate() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Anshit");
		bean.setLastName("Sankhla");
		bean.setLogin("Anshit@gmail.com");
		bean.setPassword("123456789");
		bean.setDate(sdf.parse("2000-05-21"));
		bean.setId(2);

		model.update(bean);

	}

	public static void testfindbylogin() throws Exception {

		UserModel model = new UserModel();
		UserBean existsBean = model.findbylogin("Anshit@gmail.com");

		if (existsBean != null) {
			System.out.println("login id is already exist");

		} else {
			System.out.println("no record found");
		}

	}

	public static void testAuthenticate() throws Exception {

		UserModel model = new UserModel();
		UserBean existsBean = model.authenticate("Anshit@gmail.com", "123456789");

		if (existsBean != null) {
			System.out.println("Login Successfully");
		} else {
			System.out.println("Login ID and password Invalid");
		}

	}

	public static void testchangePassword() throws Exception {
		UserModel model = new UserModel();

		model.changePassword("123456", "624574675", "Luckytomar@gmail.com");
		

	}
	public static void testsearch() throws Exception {
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setFirstName("Lucky");
		bean.setLastName("Tomar");
		bean.setPassword("624574675");
		bean.setLogin("Luckytomar@gmail.com");
		bean.setDate(sdf.parse("2006-06-01"));
		
		List list = model.search(bean);
		Iterator<UserBean> it = list.iterator();
		
		while (it.hasNext()) {
			 bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getLogin());
			System.out.print("\t"+bean.getPassword());
			System.out.println("\t"+bean.getdob());
			
		}
		
	}
	
}
