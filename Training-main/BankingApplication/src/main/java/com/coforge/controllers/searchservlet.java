package com.coforge.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchservlet
 */
@WebServlet("/searchservlet")
public class searchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public searchservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		PrintWriter out  = response.getWriter();
		
		   ServletContext context = getServletContext();
	        Connection connection = (Connection) context.getAttribute("connection");
	 
	        int accountnumber = Integer.parseInt(request.getParameter("accountnumber"));
	        String name = request.getParameter("accountholdername");
	 
	        try {
	 
	            PreparedStatement ps = connection.prepareStatement(
	                    "select*from account where accountnumber=? or accountholdername=?");
	 
	            ps.setInt(1, accountnumber);
	            ps.setString(2, name);
	 
	            ResultSet rs = ps.executeQuery();
	 
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Search Account</title>");
	            out.println("</head>");
	            out.println("<body>");
	 
	            out.println("<h2>Account Search Result</h2>");
	 
	            if (rs.next()) {
	 
	                out.println("<table border='1' cellpadding='10'>");
	 
	                out.println("<tr>");
	                out.println("<th>Account Number</th>");
	                out.println("<th>Account Holder Name</th>");
	                out.println("<th>Account Type</th>");
	                out.println("<th>Balance</th>");
	                out.println("</tr>");
	 
	                out.println("<tr>");
	                out.println("<td>" + rs.getInt("accountnumber") + "</td>");
	                out.println("<td>" + rs.getString("accountholdername") + "</td>");
	                out.println("<td>" + rs.getString("accounttype") + "</td>");
	                out.println("<td>" + rs.getDouble("balance") + "</td>");
	                out.println("</tr>");
	 
	                out.println("</table>");
	            } 
	            else 
	            {
	                out.println("<h3>Account Not Found</h3>");
	            }
	 
	            out.println("<br><br>");
	            out.println("<a href='dashboard.jsp'>Back to Dashboard</a>");
	 
	            out.println("</body>");
	            out.println("</html>");
	 
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	}

}
