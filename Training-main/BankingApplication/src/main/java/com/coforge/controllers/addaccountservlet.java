package com.coforge.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.coforge.dao.Accountdao;
import com.coforge.models.Account;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class addaccountservlet
 */
@WebServlet("/addaccountservlet")
public class addaccountservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Accountdao dAccountdao = new Accountdao();
	

    /**
     * Default constructor. 
     */
    public addaccountservlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	 
	    ServletContext context = getServletContext();
	    Connection connection = (Connection) context.getAttribute("connection");
	 
	    int accountnumber = Integer.parseInt(request.getParameter("accountnumber"));
	    String accountholdername = request.getParameter("accountholdername");
	    String accounttype = request.getParameter("accounttype");
	    double balance = Double.parseDouble(request.getParameter("balance"));
	 
	    try {
	 
	        PreparedStatement ps = connection.prepareStatement(
	                "insert into account values(?,?,?,?)");
	 
	        ps.setInt(1, accountnumber);
	        ps.setString(2, accountholdername);
	        ps.setString(3, accounttype);
	        ps.setDouble(4, balance);
	 
	        int i = ps.executeUpdate();
	 
	        if(i > 0){
	            response.getWriter().println("Account Added Successfully");
	        }
	 
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	 
	}
}
