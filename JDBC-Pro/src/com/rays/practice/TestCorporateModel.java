package com.rays.practice;

import java.util.Iterator;
import java.util.List;

public class TestCorporateModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testDelete();
		// testUpdate();
		//testfindbylogin();
		// testAuthenticate();
		// testchangepass();
		testSearch();
	}

	public static void testAdd() throws Exception {

		CorporateBean bean = new CorporateBean();
		CorporateModel model = new CorporateModel();

		bean.setUsername("Virat18");
		bean.setEmail("Virat@gmail.com");
		bean.setPassword("123456789");

		model.add(bean);

	}

	public static void testDelete() throws Exception {

		CorporateBean bean = new CorporateBean();
		CorporateModel model = new CorporateModel();
		bean.setId(2);
		model.delete(bean);
	}

	public static void testUpdate() throws Exception {
		CorporateBean bean = new CorporateBean();
		CorporateModel model = new CorporateModel();

		bean.setUsername("dhoni");
		bean.setEmail("thala@gmail,com");
		bean.setPassword("thala123");
		bean.setId(3);

		model.update(bean);
	}

	public static void testfindbylogin() throws Exception {

		CorporateModel model = new CorporateModel();
		CorporateBean existbean = model.findbylogin("thala@gmail.com");

		if (existbean != null) {
			System.out.println("Login id already exist");
		} else {
			System.out.println("no record found");
		}
	}

	public static void testAuthenticate() throws Exception {

		CorporateModel model = new CorporateModel();
		CorporateBean existbean = model.authenticate("thala@gmail,com", "thala123");

		if (existbean != null) {
			System.out.println("Login Successfully");
		} else {
			System.out.println("User id and password invalid");
		}

	}

	public static void testchangepass() throws Exception {
		CorporateBean bean = new CorporateBean();
		CorporateModel model = new CorporateModel();

		bean.setId(3);
		model.changePassword("thala123", "@Finisher", "Thala@gmail.com");
	}

	public static void testSearch() throws Exception {

		CorporateModel model = new CorporateModel();

		List list = model.search(null);
		
		Iterator<CorporateBean> it = list.iterator();
		while(it.hasNext()) {
		CorporateBean bean = it.next();
		System.out.print("\t" + bean.getId());
		System.out.print("\t" + bean.getUsername());
		System.out.print("\t" + bean.getEmail());
		System.out.println("\t" + bean.getPassword());
		
	}}

}
