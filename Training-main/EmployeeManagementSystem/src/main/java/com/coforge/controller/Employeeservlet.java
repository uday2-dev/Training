//package com.coforge.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.time.LocalDate;
//import java.util.List;
//
//import com.coforge.dao.EmployeeDAO;
//import com.coforge.models.Employee;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/Employeeservlet")
//public class Employeeservlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    public Employeeservlet() { }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String action = request.getParameter("action");
//        if (action == null) action = "list";
//
//        RequestDispatcher rd;
//
//        switch (action) {
//
//            case "list":
//                List<Employee> empList = EmployeeDAO.getAllEmployees();
//                request.setAttribute("empList", empList);
//                rd = request.getRequestDispatcher("employeelist.jsp");
//                rd.forward(request, response);
//                break;
//
//            case "new":
//                rd = request.getRequestDispatcher("Employeeform.jsp");
//                rd.forward(request, response);
//                break;
//
//            case "edit":
//                long eid = Long.parseLong(request.getParameter("eid"));
//                Employee emp = EmployeeDAO.getEmployeeById(eid);
//                request.setAttribute("employee", emp);
//                rd = request.getRequestDispatcher("Employeeform.jsp");
//                rd.forward(request, response);
//                break;
//
//			case "delete":
//			    int delId = Integer.parseInt(request.getParameter("eid"));
//			    EmployeeDAO.deleteEmployee(delId);
//			    response.sendRedirect("Employeeservlet?action=list");
//			    break;
//
//			case "info":
//				int ids =Integer.parseInt(request.getParameter("eid"));
//				Employee employee = EmployeeDAO.getEmployeeById(ids);
//				response.sendRedirect("Employeeservlet?action=list");
//				request.setAttribute("employee", employee);
//				rd = request.getRequestDispatcher("Employeeform.jsp");
//				rd.forward(request, response);
//				break;
//				
//				
//				
//            default:
//                response.sendRedirect("Employeeservlet?action=list");
//        }
//    }

    //@Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    	System.out.println(">>> doPost called <<<");
//        //String eidStr = request.getParameter("eid");
//        String ename = request.getParameter("ename");
//        long salary = Long.parseLong(request.getParameter("salary"));
//        String email = request.getParameter("email");
//        String mobile = request.getParameter("mobile");
//        LocalDate doj = LocalDate.parse(request.getParameter("doj"));
//        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
//
//        Employee emp = new Employee(ename, salary, email, mobile, doj, dob);
//
//        EmployeeDAO.addEmployee(emp);
//
//       // response.sendRedirect("Employeeservlet?action=list");
//        System.out.println(
//        	    "ename=" + ename +
//        	    ", salary=" + salary +
//        	    ", email=" + email +
//        	    ", mobile=" + mobile +
//        	    ", doj=" + doj +
//        	    ", dob=" + dob
//        	);
//       
//        response.sendRedirect("Employeeservlet?action=list");
//    }
//}



//
//
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	// TODO Auto-generated method stub
//	String eid = request.getParameter("eid");
//	String ename = request.getParameter("ename");
//	long salary = Long.parseLong(request.getParameter("salary"));
//	String email = request.getParameter("email");
//	String mobile = request.getParameter("mobile");
//	LocalDate doj = LocalDate.parse(request.getParameter("doj"));
//	LocalDate dob = LocalDate.parse(request.getParameter("dob"));
//	
//	PrintWriter out = response.getWriter();
//	RequestDispatcher rd = null;
//	if(eid==null || eid.isEmpty()) {
//		Employee e = new Employee(ename,salary,email,mobile,doj,dob);
//		EmployeeDAO.addEmployee(e);
//	
////		if(EmployeeDAO.addEmployee(e) == null) {
////			out.println("Data not added");
////		}
//		out.println(e+"Employee added");
//		List<Employee> empList = EmployeeDAO.getAllEmployees();
//		request.setAttribute("empList", empList);
//		rd = request.getRequestDispatcher("employeelist.jsp");
//		rd.forward(request, response);
//	}
//
////	} else {
////		
////	}
//	
//	else {
//		long empid = Long.parseLong(eid);
//		Employee employee = new Employee();
//		employee.setEid(empid);
//		employee.setEname(ename);
//		employee.setSalary(salary);
//		employee.setEmail(email);
//		employee.setMobile(mobile);
//		employee.setDoj(doj);
//		employee.setDob(dob);
//		EmployeeDAO.updateEmployee(employee);
//		
//	}
//	response.sendRedirect("Employeeservlet?action=list");
//
//}
//    }

    
    package com.coforge.controller;

    import java.io.IOException;
    import java.time.LocalDate;
    import java.time.format.DateTimeParseException;
    import java.util.List;

    import com.coforge.dao.EmployeeDAO;
    import com.coforge.models.Employee;

    import jakarta.servlet.RequestDispatcher;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    @WebServlet("/Employeeservlet")
    public class Employeeservlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public Employeeservlet() { }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String action = request.getParameter("action");
            if (action == null ) action = "list";

            switch (action) {

                case "list": {
                    List<Employee> empList = EmployeeDAO.getAllEmployees();
                    request.setAttribute("empList", empList);
                    RequestDispatcher rd = request.getRequestDispatcher("employeelist.jsp");
                    rd.forward(request, response);
                    return; // IMPORTANT: stop further processing
                }

                case "new": {
                    RequestDispatcher rd = request.getRequestDispatcher("Employeeform.jsp");
                    rd.forward(request, response);
                    return;
                }

                case "edit": {
                    String idParam = request.getParameter("eid");
                    if (idParam == null ) {
                        response.sendRedirect("Employeeservlet?action=list");
                        return;
                    }
                    try {
                        long eid = Long.parseLong(idParam);
                        Employee emp = EmployeeDAO.getEmployeeById(eid);
                        if (emp == null) {
                            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            request.setAttribute("errorMessage", "Employee not found: " + eid);
                            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                            rd.forward(request, response);
                            return;
                        }
                        request.setAttribute("employee", emp);
                        RequestDispatcher rd = request.getRequestDispatcher("Employeeform.jsp");
                        rd.forward(request, response);
                        return;
                    } catch (NumberFormatException nfe) {
                        response.sendRedirect("Employeeservlet?action=list");
                        return;
                    }
                }

                case "delete": {
                    String idParam = request.getParameter("eid");
                    if (idParam != null ) {
                        try {
                            int delId = Integer.parseInt(idParam);

                            // If your DAO delete signature is int, cast:
                            // EmployeeDAO.deleteEmployee((int) delId);
                            // If it's long (recommended), use:
                            EmployeeDAO.deleteEmployee(delId);

                        } catch (NumberFormatException ignore) {
                            // Bad id; just fall through to redirect
                        }
                    }
                    response.sendRedirect("Employeeservlet?action=list");
                    return;
                }

                case "info": {
                    String idParam = request.getParameter("eid");
                    if (idParam == null ) {
                        response.sendRedirect("Employeeservlet?action=list");
                        return;
                    }
                    try {
                        long infoId = Long.parseLong(idParam);
                        Employee infoEmp = EmployeeDAO.getEmployeeById(infoId);
                        if (infoEmp == null) {
                            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            request.setAttribute("errorMessage", "Employee not found: " + infoId);
                            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                            rd.forward(request, response);
                            return;
                        }
                        request.setAttribute("employee", infoEmp);
                        RequestDispatcher rd = request.getRequestDispatcher("employeeinfo.jsp");
                        rd.forward(request, response);
                        return;
                    } catch (NumberFormatException nfe) {
                        response.sendRedirect("Employeeservlet?action=list");
                        return;
                    }
                }
                case "search": {
                    String keyword = request.getParameter("keyword");

                    List<Employee> empList;

                    if (keyword == null || keyword.trim().isEmpty()) {
                        empList = EmployeeDAO.getAllEmployees();
                    } else {
                        empList = EmployeeDAO.searchEmployees(keyword.trim());
                    }

                    request.setAttribute("empList", empList);
                    RequestDispatcher rd = request.getRequestDispatcher("employeelist.jsp");
                    rd.forward(request, response);
                    return;
                }
                
                	

                default: {
                    response.sendRedirect("Employeeservlet?action=list");
                    return;
                }
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            // If your form might include non-ASCII characters, this helps:
            request.setCharacterEncoding("UTF-8");

            String eidParam = request.getParameter("eid");
            String ename    = trimOrNull(request.getParameter("ename"));
            String salaryStr= trimOrNull(request.getParameter("salary"));
            String email    = trimOrNull(request.getParameter("email"));
            String mobile   = trimOrNull(request.getParameter("mobile"));
            String dojStr   = trimOrNull(request.getParameter("doj"));
            String dobStr   = trimOrNull(request.getParameter("dob"));

            Long   eid   = null;
            Long   salary= null;
            LocalDate doj= null;
            LocalDate dob= null;

            // Parse numeric and date fields safely
            try {
                if (eidParam != null ) {
                    eid = Long.parseLong(eidParam);
                }
                if (salaryStr != null) {
                    salary = Long.parseLong(salaryStr);
                }
                if (dojStr != null) {
                    doj = LocalDate.parse(dojStr);
                }
                if (dobStr != null) {
                    dob = LocalDate.parse(dobStr);
                }
            } catch (NumberFormatException | DateTimeParseException ex) {
                // Validation error: send back to form with message & preserved values
                request.setAttribute("formError", "Invalid number or date format. Please check your inputs.");
                // Preserve user input
                request.setAttribute("eid", eidParam);
                request.setAttribute("ename", ename);
                request.setAttribute("salary", salaryStr);
                request.setAttribute("email", email);
                request.setAttribute("mobile", mobile);
                request.setAttribute("doj", dojStr);
                request.setAttribute("dob", dobStr);

                RequestDispatcher rd = request.getRequestDispatcher("Employeeform.jsp");
                rd.forward(request, response);
                return;
            }

            // Basic field check (optional, add more as needed)
            if (ename == null || salary == null || email == null || mobile == null || doj == null || dob == null) {
                request.setAttribute("formError", "All fields are required.");
                request.setAttribute("eid", eidParam);
                request.setAttribute("ename", ename);
                request.setAttribute("salary", salaryStr);
                request.setAttribute("email", email);
                request.setAttribute("mobile", mobile);
                request.setAttribute("doj", dojStr);
                request.setAttribute("dob", dobStr);
                RequestDispatcher rd = request.getRequestDispatcher("Employeeform.jsp");
                rd.forward(request, response);
                return;
            }

            if (eid == null) {
                // CREATE
                Employee e = new Employee(ename, salary, email, mobile, doj, dob);
                EmployeeDAO.addEmployee(e);

                // PRG pattern: Redirect after POST to avoid resubmission
                response.sendRedirect("Employeeservlet?action=list");
                return;

            } else {
                // UPDATE
                Employee employee = new Employee();
                employee.setEid(eid);
                employee.setEname(ename);
                employee.setSalary(salary);
                employee.setEmail(email);
                employee.setMobile(mobile);
                employee.setDoj(doj);
                employee.setDob(dob);

                EmployeeDAO.updateEmployee(employee);

                // PRG
                response.sendRedirect("Employeeservlet?action=list");
                return;
            }
        }

        private static String trimOrNull(String s) {
            if (s == null) return null;
            String t = s.trim();
            return t.isEmpty() ? null : t;
        }
    }
    
