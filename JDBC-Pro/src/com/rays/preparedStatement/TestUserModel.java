package com.rays.preparedStatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
		
		testAdd();

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

}
