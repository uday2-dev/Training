package com.coforge;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signupservlet
 */
@WebServlet("/signupservlet")
public class signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public signupservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter outPrintWriter = response.getWriter();
		String nameString = request.getParameter("name");
		String emailString = request.getParameter("email");
		String passwordString = request.getParameter("password");
		String mobiString = request.getParameter("mobile");
		
		RequestDispatcher rDispatcher = null;
	
		
		if(nameString!=null && passwordString!=null && !nameString.isEmpty() && !passwordString.isEmpty())
		{
//			request.setAttribute("name", nameString);
//			rDispatcher = request.getRequestDispatcher("/welcome.jsp");
//			rDispatcher.forward(request, response);
			response.getWriter();
			outPrintWriter.println("Signup successful");
			outPrintWriter.println("Welcome" +nameString);
		}
		else 
			{
				rDispatcher = request.getRequestDispatcher("/error.jsp");
				rDispatcher.forward(request, response);
				
			}
		System.out.println(nameString);
		System.out.println(passwordString);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
