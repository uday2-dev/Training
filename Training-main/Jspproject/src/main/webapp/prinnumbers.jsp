<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         import="java.util.Date"
         import="java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>for power</title>
</head>
<body>
<form>
<div class ="mb-3">
<label class ="form-label"> first</label>
<input type ="text" class ="form-control" name="num1" required>
<label class ="form-label"> second</label>
<input type ="text" class ="form-control" name="num2" required>
<button class ="btn btn-primary">power</button>

</div>
</form>
<%! public static double powernums(String s1, String s2)
{
	if(s1!=null && s2!=null)
	{
		double ans = Math.pow(Double.parseDouble(s1),Double.parseDouble(s2));
		return ans;
	}
	return 0;
	
}
%>
<%@ include file="header.jsp" %>

<% 
String s1 = request.getParameter("num1");
String s2 = request.getParameter("num2");

out.println("the power of number is : " +powernums(s1,s2));
%>
</form>
</body>
</html>