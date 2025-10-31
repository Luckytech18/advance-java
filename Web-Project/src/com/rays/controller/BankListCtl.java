package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.BankBean;
import com.rays.model.BankModel;

@WebServlet("/BankListCtl")
public class BankListCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BankBean bean = new BankBean();
		BankModel model = new BankModel();
		int pageNo = 1;
		int pageSize = 5;
		
		try {
			List list = model.search(bean, pageNo, pageSize);
			List nextlist = model.search(bean, pageNo, pageSize) ;
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("list", list);
			request.setAttribute("nextlist", nextlist);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("BankList.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
