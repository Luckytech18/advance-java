package com.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("FileView.jsp");
		System.out.println("---in Get Method-----");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("FileView.jsp");
		System.out.println("---In DoPost-----");
		String firstName = request.getParameter("firstName");
		String lastName =request.getParameter("lastName");
		String login =request.getParameter("login");
		String password =request.getParameter("password");
		String Dob =request.getParameter("dob");
		
		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + Dob );
			}

}
