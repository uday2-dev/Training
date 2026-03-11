package com.coforge;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;   
import org.apache.logging.log4j.Logger;   

import org.apache.logging.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.ExtensionMethod;


/**
 * Servlet implementation class loggingservletwithout
 */
@WebServlet("/loggingservletwithout")
public class loggingservletwithout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(loggingservletwithout.class);

    /**
     * Default constructor. 
     */
    public loggingservletwithout() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String unameString = request.getParameter("uname");
		String clientIpString = request.getRemoteAddr();
		String headerString = request.getHeader("User-Agent");
		String methodString =request.getMethod();
		logger.info("Form Submitted at {}",LocalDate.now());
		logger.info("User Name : {}",unameString);
		logger.info("Client IP {}",clientIpString);
		logger.info("User Agent {}",headerString);
		logger.info("Request Method {}",methodString);
		
		
		
	}
	public void sayHello() {
		logger.info("say hello {}",LocalDateTime.now());
		logger.info("printing hello msg");
		System.out.println("helllo");
		logger.info("sayhello complete{}",LocalDateTime.now());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

//
//package com.coforge;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/loggingservletwithout")
//public class loggingservletwithout extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    private static final Logger LOGGER = Logger.getLogger(loggingservletwithout.class.getName());
//
//    public loggingservletwithout() { }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String uname = request.getParameter("uname");
//        String clientIp = request.getRemoteAddr();
//        String userAgent = request.getHeader("User-Agent");
//        String method = request.getMethod();
//
//        LOGGER.log(Level.INFO, "Form submitted at {0}", LocalDate.now());
//        LOGGER.log(Level.INFO, "User Name: {0}", uname);
//        LOGGER.log(Level.INFO, "Client IP: {0}", clientIp);
//        LOGGER.log(Level.INFO, "User Agent: {0}", userAgent);
//        LOGGER.log(Level.INFO, "Request Method: {0}", method);
//
//        response.setContentType("text/plain; charset=UTF-8");
//        response.getWriter().println("Logged request. Check server logs.");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
//}