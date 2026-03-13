<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Deposit Money</h2>
 
<form action="depositservlet" method="post">
 
Account Number:
<input type="number" name="accountnumber" required>
 
<br><br>
 
Amount to Deposit:
<input type="number" name="balance" required>
 
<br><br>
 
<input type="submit" value="Deposit">
 
</form>

</body>
</html>