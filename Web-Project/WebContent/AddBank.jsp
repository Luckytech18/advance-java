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
	<div align="center">
		<h1>Add BankUser</h1>
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
		


		<form action="AddBankCtl" method="post">
			<table>
				<tr>
					<th>Account No.</th>
					<td><input type="text" name="accountNo" value=""
						placeholder="enter account no."></td>

				</tr>
				<tr>
					<th>FirstName</th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter firstName"></td>

				</tr>
				<tr>
					<th>LastName</th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter LastName"></td>

				</tr>
				<tr>
					<th>Account Type</th>
					<td><input type="text" name="accType" value=""
						placeholder="enter AccType"></td>

				</tr>
				<tr>
					<th>Dob</th>
					<td><input type="date" name="dob" value=""
						placeholder="enter dob"></td>

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