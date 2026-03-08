<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style ="color: blue"> Welcome</h1>
	<%String uname = (String)session.getAttribute("username");
	
	if(uname!=null)
	{
		out.println("my session attribute " +uname);
		out.println("session id :" +session.getId());
		out.println("session time :"+new java.util.Date(session.getCreationTime()));
	}
	else
	{
		out.println("no session found ");
	}
	
	
	
	%>
	
	
</body>
</html>