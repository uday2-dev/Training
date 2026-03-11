<%@page import="jakarta.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style ="color :red"> Invalid login credentials please re login</h1>
	<% RequestDispatcher rDispatcher = request.getRequestDispatcher("login.jsp");
	rDispatcher.forward(request,response);%>
</body>
</html>