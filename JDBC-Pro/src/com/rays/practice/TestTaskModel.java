package com.rays.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestTaskModel {
	
	public static void main(String[] args) throws Exception {
		
		testadd();
		
	}
	public static void testadd() throws Exception {
		
		TaskBean bean = new TaskBean();
		TaskModel model = new TaskModel();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setDob(sdf.parse("20005-01-18"));
		bean.setDetails("mumbai");
		bean.setStatus("Active");
		
		
		model.add(bean);
		
	}

	
}
