package com.rays.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.BankBean;
import com.rays.model.BankModel;
import com.rays.model.UserModel;

@WebServlet("/AddBankCtl")
public class AddBankCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("AddBank.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BankModel model = new BankModel();
		BankBean bean = new BankBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String accountNo = request.getParameter("accountNo");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String accType = request.getParameter("accType");
		String dob = request.getParameter("dob");
		try {
			bean.setAccountNo(accountNo);
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setAccType(accType);

			bean.setDob(sdf.parse(dob));

			model.add(bean);
			request.setAttribute("successMsg", "Data Added successfully");
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("AddBank.jsp");
		rd.forward(request, response);
	}

}
