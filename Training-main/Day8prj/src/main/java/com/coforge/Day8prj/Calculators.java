package com.coforge.Day8prj;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Calculators {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.cj.jdbc.Driver");
	     System.out.println("Driver loaded");
	     String unameString = "root";
	     String passwordString = "root";

	     String urlString = "jdbc:mysql://localhost:3306/temp1";

	     Connection connection = DriverManager.getConnection(urlString, unameString, passwordString);
	     System.out.println("Connection Established");
	     
	     String query1 = "{call add_numbers(?,?,?)}";
	     CallableStatement cStatement = connection.prepareCall(query1);
	     System.out.println("Query called");
	     cStatement.setInt(1, 34);
	     cStatement.setInt(2, 67);
	     cStatement.registerOutParameter(3, Types.INTEGER);
	     
	     cStatement.execute();
	     int sum = cStatement.getInt(3);
	     
	     System.out.println("Result : " + sum);
	     // now create three more products 
	     // sub mul div mod rem
	     
	}

}
