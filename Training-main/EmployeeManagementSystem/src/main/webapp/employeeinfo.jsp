<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.coforge.models.Employee" %>

<%
    Employee emp = (Employee) request.getAttribute("employee");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Information</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 
    <style>
        body {
            background-color: #f5f7fa;
        }
        .container {
            max-width: 800px;
            margin-top: 40px;
        }
        .label {
            font-weight: 600;
            color: #555;
        }
    </style>
</head>

<body>
<div class="container">

    <h3 class="mb-4">Employee Information</h3>

    <% if (emp == null) { %>
        <div class="alert alert-danger">
            Employee details not found.
        </div>
        <a href="Employeeservlet?action=list">Back to List</a>
    <% } else { %>

        <div class="card shadow-sm">
            <div class="card-body">

                <div class="row mb-3">
                    <div class="col-md-4 label">Employee ID</div>
                    <div class="col-md-8"><%= emp.getEid() %></div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4 label">Name</div>
                    <div class="col-md-8"><%= emp.getEname() %></div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4 label">Email</div>
                    <div class="col-md-8"><%= emp.getEmail() %></div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4 label">Mobile</div>
                    <div class="col-md-8"><%= emp.getMobile() %></div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4 label">Salary</div>
                    <div class="col-md-8"><%= emp.getSalary() %></div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4 label">Date of Joining</div>
                    <div class="col-md-8"><%= emp.getDoj() %></div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-4 label">Date of Birth</div>
                    <div class="col-md-8"><%= emp.getDob() %></div>
                </div>

            </div>

            <div class="card-footer d-flex gap-2">
              
               <a href="Employeeservlet?action=list">Back to List</a>
            </div>
        </div>

    <% } %>
</div>



</body>
</html>