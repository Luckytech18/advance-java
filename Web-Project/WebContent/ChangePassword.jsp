<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String successMsg = (String) request.getAttribute("successMsg");
		String errorMsg = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">
		<h1>Change Password</h1>

		<%
			if (errorMsg != null) {
		%>
		<h2 style="color: red"><%=errorMsg%></h2>
		<%
			}
		%>
		<%
			if (successMsg != null) {
		%>
		<h2 style="color: green"><%=successMsg%></h2>
		<%
			}
		%>

		<form action="ChangePasswordCtl" method="post">
			<table>
				<tr>
					<th>LogIn</th>
					<td><input type="email" name="login" value=""
						placeholder="Enter Your Email"></td>
				</tr>

				<tr>
					<th>OldPassword</th>
					<td><input type="password" name="oldPassword" value=""
						placeholder="Enter Your password"></td>
				</tr>

				<tr>
					<th>NewPassword</th>
					<td><input type="password" name="newPasssword" value=""
						placeholder="Enter New Password"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="save"></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>