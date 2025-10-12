<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<%
		String successMsg = (String) request.getAttribute("successMsg");
		String errorMsg = (String) request.getAttribute("errorMsg");
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<div align="center">

		<%
			if (bean != null && bean.getId() > 0) {
		%>

		<h3>Update user</h3>

		<%
			} else {
		%>

		<h1>Add User</h1>

		<%
			}
		%>


		<%
			if (successMsg != null) {
		%>
		<h3 style="color: green"><%=successMsg%></h3>
		<%
			}
		%>
		<%
			if (errorMsg != null) {
		%>
		<h3 style="color: red"><%=errorMsg%></h3>
		<%
			}
		%>
		<form action="UserViewCtl" method="post">
			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">
			<table>
				<tr>
					<th>FirstName</th>
					<td><input type="text" name="firstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="Enter FirstName"></td>
				</tr>

				<tr>
					<th>LastName</th>
					<td><input type="text" name="lastName" value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="Enter LastName"></td>
				</tr>

				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value="<%=bean != null ? bean.getLogin() : ""%>"
						placeholder="Enter Email"></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value="<%=bean != null ? bean.getPassword() : ""%>"
						placeholder="Enter Password"></td>
				</tr>

				<tr>
					<th>Dob</th>
					<td><input type="date" name="dob" value="<%=bean != null ? bean.getdob() : ""%>"
						placeholder="Enter Dob"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="<%=bean != null ? "Update" : "Save"%>"></td>
				</tr>








			</table>
		</form>
	</div>

</body>
</html>