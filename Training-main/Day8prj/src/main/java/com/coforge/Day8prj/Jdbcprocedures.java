package com.coforge.Day8prj;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Callable;

public class Jdbcprocedures {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	     System.out.println("Driver loaded");
	     String unameString = "root";
	     String passwordString = "root";

	     String urlString = "jdbc:mysql://localhost:3306/temp";

	     Connection connection = DriverManager.getConnection(urlString, unameString, passwordString);
	     System.out.println("Connection Established");
	     
	     String query1 = "{call get_allstudents()}";
	     CallableStatement cStatement = connection.prepareCall(query1);
	     System.out.println("Query called");
	     Statement statement = connection.createStatement();
         String queryString1 = "select * from students";
         ResultSet rSet = statement.executeQuery(queryString1);
         System.out.println("students data");

         while(rSet.next()) {
             System.out.println(rSet.getInt(1));
             System.out.println(rSet.getString(2));
             System.out.println(rSet.getDouble(3));
             System.out.println(rSet.getString(4));
             
         }

	}
	
}
