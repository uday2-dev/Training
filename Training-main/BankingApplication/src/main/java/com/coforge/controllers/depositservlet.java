package com.coforge.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class depositservlet
 */
@WebServlet("/depositservlet")
public class depositservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public depositservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		Connection connection = (Connection) context.getAttribute("connection");
		
		int accountnumber = Integer.parseInt(request.getParameter("accountnumber"));
		double balance = Double.parseDouble(request.getParameter("balance"));
		
		try {
			PreparedStatement pStatement  =connection.prepareStatement(
				 "update account set balance = balance + ? where accountnumber=?");
			pStatement.setDouble(1, balance);
			pStatement.setInt(2, accountnumber);
			
			
			int result = pStatement.executeUpdate();
			PrintWriter outPrintWriter = response.getWriter();
			if(result>0)
			{
				outPrintWriter.println("deposit successful");
			}
			else {
				outPrintWriter.println("not found account");
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
