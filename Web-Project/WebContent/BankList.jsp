<%@page import="com.rays.bean.BankBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
		List list = (List) request.getAttribute("list");
		int pageNo = (int) request.getAttribute("pageNo");
		List nextList = (List) request.getAttribute("nextList");
	%>

	<table border="1px" width="100%">

		<tr style="background-color: skyblue">
			<th>Account No</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Account Type</th>
			<th>DOB</th>

		</tr>


		<%
			Iterator<BankBean> it = list.iterator();
		%>
		<%
			while (it.hasNext()) {
				BankBean bean = it.next();
		%>
		<tr align="center" style="background-color: #D3D3D3">
			<td><%=bean.getAccountNo()%></td>
			<td><%=bean.getFirstName()%></td>
			<td><%=bean.getLastName()%></td>
			<td><%=bean.getAccType()%></td>
			<td><%=bean.getDob()%></td>

		</tr>
		<%
			}
		%>
	</table>
</body>
</html>