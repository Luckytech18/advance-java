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
		<h1>Login View</h1>
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
		<form action="LoginCtl" method="post">

			<table>

				<tr>
					<th>Login</th>
					<td><input type="email" name="Login" value=""
						placeholder="Enter your emaill"><span style="color:red"><%=request.getAttribute("Login")!= null ? request.getAttribute("Login") : "" %></span></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="Password" name="Password" value=""
						placeholder="Enter Your Password"><span style="color:red"><%=request.getAttribute("Password")!= null ? request.getAttribute("Password") : "" %></span></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="SignIn" name="operation"></td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>