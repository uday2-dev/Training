package com.coforge.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coforge.dao.Customerdao;
import com.coforge.entities.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// business logics here
import lombok.SneakyThrows;


/**
 * Servlet implementation class Customerservlet
 */
@WebServlet("/Customerservlet")
public class Customerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Customerservlet() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	Customerdao daoCustomer = new Customerdao();
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Customerdao dao = new Customerdao();
		PrintWriter outPrintWriter = response.getWriter();
		String actionString = request.getParameter("action");
//		if(actionString.equals("select"))
//		{
//			try {
//				getAllCustomer();
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		else if
//	
//		else
//			outPrintWriter.println("no customer found");
		
		switch(actionString)
		{
		case "select" : try {
				getAllCustomer();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		case "insert":
			String reString = null;
			try {
				reString = addCustomer();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outPrintWriter.println(reString);
			break;
		case "getbyid":
			try {
				outPrintWriter.println(getCustomerById());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//		default:
//            outPrintWriter.println("no customer found");
//		
		}
		
//		
		
	}
		
		//List<Customer> getAllCustomer() throws ClassNotFoundException, SQLException
		public  List<Customer> getAllCustomer() throws ClassNotFoundException, SQLException
		{
			Customerdao daoCustomer = new Customerdao();
             return daoCustomer.getAllCustomers();
//			List<Customer>customerlistCustomers = daoCustomer.getAllCustomers();
////			System.out.println(customerlistCustomers);
//			customerlistCustomers.forEach(c->System.out.println(c));
		}
		public String addCustomer() throws ClassNotFoundException, SQLException
		{
			Customerdao daoCustomer = new Customerdao();
			Customer customer= new Customer(237,"ayush","banglore","ayush@gmail.com","909099090");
			return daoCustomer.addCustomer(customer);
		}
		
		public Customer getCustomerById() throws ClassNotFoundException, SQLException
		{
			Customerdao daoCustomer = new Customerdao();
			return daoCustomer.getCustomerById(2l);
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


