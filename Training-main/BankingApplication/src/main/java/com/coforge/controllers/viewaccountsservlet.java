package com.coforge.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coforge.dao.Accountdao;
import com.coforge.models.Account;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class viewaccountservlet
 */
@WebServlet("/viewaccountsservlet")
public class viewaccountsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Accountdao dAccountdao = new Accountdao();

    /**
     * Default constructor. 
     */
    public viewaccountsservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        Connection connection = (Connection) context.getAttribute("connection"); 
        System.out.println("cinnn "+connection);
        List<Account> accountlist = new ArrayList<Account>();
        try {
            accountlist = Accountdao.getAllAccounts(connection); 
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.println("<html> <body><table border='3px'>");
        outPrintWriter.println("<thead><tr><th>Account Number</th><th>Account Holder Name</th>");
        outPrintWriter.println("<th>Account Type</th><th>Balance</th></tr></thead>");
        outPrintWriter.println("<tbody>");
        for (Account acc : accountlist) {
            outPrintWriter.println("<tr><td>" + acc.getAccountnumber() + "</td>");
            outPrintWriter.println("<td>" + acc.getAccountholdername() + "</td>");
            outPrintWriter.println("<td>" + acc.getAccounttype() + "</td>");
            outPrintWriter.println("<td>" + acc.getBalance() + "</td></tr>");
        }
        outPrintWriter.println("</tbody></table></body></html>");
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
