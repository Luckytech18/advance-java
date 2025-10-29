<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%@ include file="Header.jsp"%>
	<%
		String successMSg = (String) request.getAttribute("successMsg");
		String errorMsg = (String) request.getAttribute("errorMsg");
	%>
	<div align="center">
		<h1>User Registration</h1>

		<%
			if (successMSg != null) {
		%>
		<h3 style="color: green;">
			<%=successMSg%></h3>
		<%
			}
		%>
		<%
			if (errorMsg != null) {
		%>
		<h3 style="color: red;"><%=errorMsg%></h3>
		<%
			}
		%>

		<form action="UserRegistrationCtl" method="post">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="FirstName" value=""
						placeholder="enter the first name"><span
						style="color: red"><%=request.getAttribute("FirstName") != null ? request.getAttribute("FirstName") : ""%></span></td>
				</tr>

				<tr>
					<th>Last Name</th>
					<td><input type="text" name="LastName" value=""
						placeholder="enter the last name"><span
						style="color: red"><%=request.getAttribute("LastName") != null ? request.getAttribute("LastName") : ""%></span></td>
				</tr>

				<tr>
					<th>Login</th>
					<td><input type="email" name="Login" value=""
						placeholder="Enter your emaill"><span
						style="color: red"><%=request.getAttribute("Login") != null ? request.getAttribute("Login") : ""%></span></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="Password" name="Password" value=""
						placeholder="Enter Your Password"><span
						style="color: red"><%=request.getAttribute("Password") != null ? request.getAttribute("Password") : ""%></span></td>
				</tr>

				<tr>
					<th>DOB</th>
					<td><input type="date" name="Dob" value=""
						placeholder="Enter your date of birth"><span
						style="color: red"><%=request.getAttribute("Dob") != null ? request.getAttribute("Dob") : ""%></span></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="SignUp" name="operation"></td>
				</tr>
			</table>

		</form>
	</div>

</body>
</html>