package com.coforge;

import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class loginservelt
 */
@WebServlet("/loginservelt")
public class loginservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginservelt() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter outPrintWriter = response.getWriter();
		String unameString = request.getParameter("uname");
		String passString = request.getParameter("pwd");
		RequestDispatcher rDispatcher = null;
		
		
		if(unameString.equals("uday") && passString.equals("uday")) {
			request.setAttribute("uname",unameString);
			rDispatcher = request.getRequestDispatcher("/welcome.jsp");
			rDispatcher.forward(request, response);
			
		}
		
		
		else {
			rDispatcher = request.getRequestDispatcher("/error.jsp");
			rDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
