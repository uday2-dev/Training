<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding Numbers</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
<div class  = "container mt-5">
<div class ="row justify-content-center"> 
<div class = "col-md-5">
<div class="card shadow">
<div class = "card-header text-center bg-primary text-white">
<h3> Add two numbers</h3>
<div class = "card-body">
<form>
<div class ="mb-3">
<label class ="form-label"> first</label>
<input type ="text" class ="form-control" name="num1" required>
<label class ="form-label"> second</label>
<input type ="text" class ="form-control" name="num2" required>
<button class ="btn btn-primary"> Addition</button>

</div>
</form>


</div>


</div>
</div>
</div>
</div>
</div>

<%!
public static int addnum(String n1, String n2){
	if(n1!=null && n2!=null)
	{
		int res  = Integer.parseInt(n1)+Integer.parseInt(n2);
		return res;
		
} return 0;
}
	%>
	<%
String s1 = request.getParameter("num1");
String s2 = request.getParameter("num2");
int n1 = 0, n2 = 0;

  
out.println("Addition of nums  :" +addnum(s1,s2));


 %>


</body>
</html>




