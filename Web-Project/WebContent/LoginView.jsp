<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%@ include file="Header.jsp"%>
	<div align="center">
		<h1>Login View</h1>
		<form action="GetForm.jsp">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="FirstName" value=""
						placeholder="enter the first name"></td>
				</tr>

				<tr>
					<th>Last Name</th>
					<td><input type="text" name="LastName" value=""
						placeholder="enter the last name"></td>
				</tr>

				<tr>
					<th>Login</th>
					<td><input type="email" name="Login" value=""
						placeholder="Enter your emaill"></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="Password" name="Password" value=""
						placeholder="Enter Your Password"></td>
				</tr>

				<tr>
					<th>DOB</th>
					<td><input type="date" name="Dob" value=""
						placeholder="Enter your date of birth"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value=save name="operation"></td>
				</tr>


</table>




		</form>

	</div>

</body>
</html>