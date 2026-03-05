<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGN up page</title>
</head>
<body>
	<h2> Signup page</h2>
	<form action ="signupservlet" method ="post">
	Name : <input type ="text" name = "name"><br>
	Email : <input type="email" name ="email"><br>
	Password :<input type = "password" name ="password"><br>
	Mobile number : <input type ="mobilenumber" name = "mob"><br>
	
	<input type ="submit" value ="register">
	
	
	</form>
</body>
</html>