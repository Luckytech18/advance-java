package com.rays.utill;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DataValidator {

	public static boolean signUpValidation(HttpServletRequest request) {
		Boolean isValid = true;

		System.out.println("FirstName:" + request.getParameter("firstName"));

		if (request.getParameter("FirstName") == "") {
			request.setAttribute("FirstName", "firstName is required");
			System.out.println("FirstName is required");
			isValid = false;

		} else if (!(request.getParameter("FirstName").endsWith("1234567890"))) {
			request.setAttribute("FirstName", "Charachter contains only");
			isValid = false;
		}
		if (request.getParameter("LastName") == "") {
			request.setAttribute("LastName", "LastName is required");
			System.out.println("LastName is required");
			isValid = false;

		} else if (!(request.getParameter("LastName").endsWith("1234567890"))) {
			request.setAttribute("LastName", "Charachter contains only");
			isValid = false;
		}
		if (request.getParameter("Login") == "") {
			request.setAttribute("Login", "Login is required");
			System.out.println("Login is required");
			isValid = false;

		} else if (!request.getParameter("Login").endsWith("@gmail.com")) {
			request.setAttribute("Login", "invalid login format");
			isValid = false;
		}

		if (request.getParameter("Password") == "") {
			request.setAttribute("Password", "password is required");
			System.out.println("Password is required");
			isValid = false;

		} else if (!(request.getParameter("Password").length() >= 8
				|| request.getParameter("Password").length() <= 12)) {
			request.setAttribute("Password", "Your password must be between 8 and 12 characters long.");
			System.out.println("password is required");
			isValid = false;
		}
		if (request.getParameter("Dob") == "") {
			request.setAttribute("Dob", "Dob is required");
			System.out.println("Dob is required");
			isValid = false;

		} else if (!(request.getParameter("Dob") == "")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date dob = sdf.parse(request.getParameter("Dob"));
				Date now = new Date();
				int age = now.getYear() - dob.getYear();
				if (!(age >= 18 && age <= 60)) {
					request.setAttribute("Dob", "you are not eligible for this website");
					isValid = false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isValid;
	}

	public static boolean LoginValidation(HttpServletRequest request) {
		Boolean isValid = true;

		System.out.println("FirstName:" + request.getParameter("firstName"));

		if (request.getParameter("Login") == "") {
			request.setAttribute("Login", "Login is required");
			System.out.println("Login is required");
			isValid = false;

		}
		if (request.getParameter("Password") == "") {
			request.setAttribute("Password", "password is required");
			System.out.println("Password is required");
			isValid = false;

		}

		return isValid;

	}

}
