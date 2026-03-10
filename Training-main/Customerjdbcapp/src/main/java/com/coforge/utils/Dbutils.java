package com.coforge.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutils {
	
	// it is used for the jdbc connection
	 private static final String urlString = "jdbc:mysql://localhost:3306/users";
	private  static final String unameString = "root";
     private static final String passwordString = "root";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        
        Connection connection = DriverManager.getConnection(urlString,unameString,passwordString);
        System.out.println("Connection Established");
		return connection;
	}

}
