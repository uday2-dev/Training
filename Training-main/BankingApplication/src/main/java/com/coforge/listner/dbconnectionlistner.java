package com.coforge.listner;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.print.attribute.PrintJobAttribute;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class dbconnectionlistner
 *
 */
@WebListener
public class dbconnectionlistner implements ServletContextListener {
	private Connection connection;
	

    /**
     * Default constructor. 
     */
    public dbconnectionlistner() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
 
    	
    	ServletContextListener.super.contextInitialized(sce);
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
           String urlString = "jdbc:mysql://localhost:3306/bank";
           String unameString = "root";
           String passString  ="root";
           connection = DriverManager.getConnection(urlString,unameString,passString);
           
           
        ServletContext context = sce.getServletContext();
        context.setAttribute("connection",connection);
        System.out.println("connection created and added to context");
        
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    	ServletContextListener.super.contextDestroyed(sce);
    	try {
//			if(connection!=null && !connection.isClosed())
//			{
				connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}

//