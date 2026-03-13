<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Update Form</h2>
 
<form action="updateservlet" method="post"> 
Account Number:
<input type="number" name="accountnumber" required>
Account Holder Name:
<input type="text" name="accountholdername" required>
 
<br><br>
 
Account Type:
<input type="text" name="accounttype" required>
 
<br><br>
 
<input type="submit" value="Update">
</body>
</html>