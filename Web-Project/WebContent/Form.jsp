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

		<form action="GetForm.jsp">
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="FirstName"
						value""
   placeholder="enter the first name"></td>
				</tr>

				<tr>
					<th>Last Name</th>
					<td><input type="text" name="LastName" value=""
					placeholder="enter your LastName"></td>
				</tr>

				<tr>
					<th>Login</th>
					<td><input type="text" name="login" value=""
					placeholder="enter your EMAIL"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="Password" value=""
					placeholder="Enter your password"></td>
				</tr>

				<tr>
					<th>Dob</th>
					<td><input type="date" name="dob" value = ""></td>
				</tr>
				<tr>
				<th></th>
				<td><input type="submit" value="save" name="operation" ></td>
				</tr>


			</table>

		</form>
	</div>

</body>
</html>