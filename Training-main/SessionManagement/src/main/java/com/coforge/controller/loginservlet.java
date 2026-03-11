package com.coforge.controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailString = request.getParameter("email");
		String passString = request.getParameter("password");
		
		if(emailString.equals("admin@gmail.com") && passString.equals("admin123"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", emailString);
			session.setMaxInactiveInterval(300);
			response.sendRedirect("userprofile.jsp");
			
		}
		else {
			RequestDispatcher rDispatcher = request.getRequestDispatcher("error.jsp");
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
