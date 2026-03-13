<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>withdraw Money</h2>
 
<form action="withdrawservlet" method="post">
 
Account Number:
<input type="number" name="accountnumber" required>
 
<br><br>
 
Amount to withdraw:
<input type="number" name="balance" required>
 
<br><br>
 
<input type="submit" value="withdraw">
 
</form>
</body>
</html>