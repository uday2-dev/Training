<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Account</h2>
 
<form action="addaccountservlet" method="post">
 
Account Number:
<input type="number" name="accountnumber"><br><br>
 
Account Holder Name:
<input type="text" name="accountholdername"><br><br>
 
Account Type:
<input type="text" name="accounttype"><br><br>
 
Balance:
<input type="number" name="balance"><br><br>
 
<input type="submit" value="Add Account">
 
</form>
</body>
</html>