package com.coforge;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;   
import org.apache.logging.log4j.Logger;   


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;


/**
 * Servlet Filter implementation class loggingwithfilter
 */
@WebFilter("/*")
public class loggingwithfilter extends HttpFilter implements Filter {
	private static final Logger logger = LogManager.getLogger(loggingwithfilter.class);
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public loggingwithfilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("LoggingFilter Exit time {}" , LocalDateTime.now());
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest request2 = (HttpServletRequest)request;
		String urlString = request2.getRequestURI();
		String methodString = request2.getMethod();
		String ipString = request2.getRemoteAddr();
		logger.info("Incoming request -> Method {}, URI : {} IP:{}",methodString,urlString,ipString);
		
		long starttime = System.currentTimeMillis();
		chain.doFilter(request, response);
		long endtime = System.currentTimeMillis();
		logger.info("Response sent -> URI {} : Time taken : {} ms ", urlString,(endtime-starttime));
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("Logging filter starting time :{}",LocalDateTime.now());
	}

}
