package com.coforge.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateservlet
 */
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public updateservlet() {
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
		ServletContext context = getServletContext();
		Connection connection = (Connection)context.getAttribute("connection");
		int accountnumber = Integer.parseInt(request.getParameter("accountnumber"));
		String accountholdername = request.getParameter("accountholdername");
		String accounttype = request.getParameter("accounttype");
		PrintWriter outPrintWriter = response.getWriter();
		
		try {
			if(accountnumber>0)
			{
				PreparedStatement pStatement = connection.prepareStatement(
					"update account set accountholdername=?, accounttype=? where accountnumber=?"
						);
				pStatement.setString(1, accountholdername);
				pStatement.setString(2, accounttype);
				pStatement.setInt(3, accountnumber);
				pStatement.executeUpdate();
				
				outPrintWriter.println("account updated");
				
				
			}
			else {
				outPrintWriter.println("enter correct account number or account doesnot exist");
				
			}
			
					
					
					
					
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
