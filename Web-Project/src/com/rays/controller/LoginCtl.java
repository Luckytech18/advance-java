package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
import com.rays.utill.DataValidator;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("operation");
		System.out.println("op mila--->" + op);

		if (op != null) {
			if (!DataValidator.LoginValidation(request)) {
				System.out.println("Data validate nhi hai");
				RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
				rd.forward(request, response);
				return;
			}
		}
		
		super.service(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("op----->" + op);
		
		
		if (op != null) {
			HttpSession session = request.getSession();
			session.invalidate();// destroy session
			request.setAttribute("successMsg", "user logout successfully");
		}
		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Login = request.getParameter("Login");
		String Password = request.getParameter("Password");
		
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		HttpSession session = request.getSession();

		try {
			bean = model.authenticate(Login, Password);
			if (bean != null) {
				System.out.println("User Login Successfully");
				response.sendRedirect("WelcomeCtl");
				session.setAttribute("user", bean);
			} else {
				request.setAttribute("errorMsg", "Invalid Login and Password");
				RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
				rd.forward(request, response);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}