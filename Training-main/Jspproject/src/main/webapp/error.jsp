<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style ="color : red"> Enter correct credentials</h1>
	<% out.println("Exception occurred " +exception +"<br>");
	out.println("Message : "+exception.getMessage() "<br>");%>
</body>
</html>