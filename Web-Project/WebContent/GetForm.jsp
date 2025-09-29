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
String firstname = request.getParameter("FirstName");
String Lastname = request.getParameter("LastName");
String login = request.getParameter("Login");
String password = request.getParameter("Password");
String dob = request.getParameter("Dob");
%>

<h1><%=firstname %></h1>
<h1><%=Lastname %></h1>
<h1><%=login %></h1>
<h1><%=password %></h1>
<h1><%=dob %></h1>

</body>
</html>