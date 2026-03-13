<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Search Account</h2>
<form action="searchservlet"method="post">
Account Number:
<input type="number" name="accountnumber"><br><br>
Account Holder Name:
<input type="text" name="accountholdername"><br><br>
<input type="submit" value="Search Account">
</form>
</body>
</html>