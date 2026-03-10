//package com.coforge.controller;
//
//import java.io.IOException;
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
//                int eid = Integer.parseInt(request.getParameter("eid"));
//                Employee emp = EmployeeDAO.getEmployeeById(eid);
//                request.setAttribute("employee", emp);
//                rd = request.getRequestDispatcher("Employeeform.jsp");
//                rd.forward(request, response);
//                break;
//
//            default:
//                response.sendRedirect("Employeeservlet?action=list");
//        }
//    }
//
//    @Override
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

package com.coforge.controller;

import java.io.IOException;
import java.time.LocalDate;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {

            case "list":
                List<Employee> empList = EmployeeDAO.getAllEmployees();
                request.setAttribute("empList", empList);
                request.getRequestDispatcher("employeelist.jsp")
                       .forward(request, response);
                break;

            case "new":
                request.getRequestDispatcher("Employeeform.jsp")
                       .forward(request, response);
                break;

            case "edit":
                int eid = Integer.parseInt(request.getParameter("eid"));
                Employee emp = EmployeeDAO.getEmployeeById(eid);
                request.setAttribute("employee", emp);
                request.getRequestDispatcher("Employeeform.jsp")
                       .forward(request, response);
                break;

            default:
                response.sendRedirect("Employeeservlet?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String eidStr = request.getParameter("eid");
        String ename = request.getParameter("ename");
        long salary = Long.parseLong(request.getParameter("salary"));
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        LocalDate doj = LocalDate.parse(request.getParameter("doj"));
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));

        if (eidStr == null || eidStr.isEmpty()) {
            Employee emp = new Employee(ename, salary, email, mobile, doj, dob);
            EmployeeDAO.addEmployee(emp);
        } else {
            int eid = Integer.parseInt(eidStr);
            Employee emp = new Employee(eid, ename, salary, email, mobile, doj, dob);
            EmployeeDAO.updateEmployee(emp);
        }

        response.sendRedirect("Employeeservlet?action=list");
    }
}