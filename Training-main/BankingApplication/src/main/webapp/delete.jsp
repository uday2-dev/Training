<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Delete Account</h2>
 
<form action="deleteservlet" method="post">
 
Account Number:
<input type="number" name="accountnumber" required>
 
<br><br>
 
<!-- Account Holder Name:
<input type="number" name="accountholdername" required> -->
 
<br><br>
 
<input type="submit" value="Delete">
</body>
</html>