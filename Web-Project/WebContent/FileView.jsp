<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>User Form</h1>
		<form action="FirstServlet" method="post">
			<table>
				<tr>
					<th>FirstName</th>
					<td><input type="text" name="firstName" value=""
						placeholder="Enter Your Name"></td>

				</tr>

				<tr>
					<th>LastName</th>
					<td><input type="text" name="lastName" value=""
						placeholder="Enter Your Name"></td>

				</tr>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="Enter Your email"></td>

				</tr>
				
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="Enter Your password"></td>

				</tr>
				<tr>
					<th>Dob</th>
					<td><input type="date" name="dob" value=""
						placeholder="Enter Your dob"></td>

				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="save">
					</td>
				</tr>
			</table>

		</form>
</div>

</body>
</html>