package com.coforge.Day7jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello World!");
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        String unameString = "root";
        String passwordString = "root";
        
        String urlString = "jdbc:mysql://localhost:3306/classic22";
        
        Connection connection = DriverManager.getConnection(urlString,unameString,passwordString);
        System.out.println("Connection Established");
        
        
        Statement statement = connection.createStatement();
        String queryString = "select * from employees";
        
      ResultSet rSet  =   statement.executeQuery(queryString);
      System.out.println("student data");
      while(rSet.next())
      {
    	  System.out.println(rSet.getInt(1));
    	  System.out.println(rSet.getString(2));
    	  System.out.println(rSet.getString(3));
    	  System.out.println(rSet.getString(4));
    	  System.out.println(rSet.getString(5));
    	  
    	  System.out.println("***************");
      }
        
    }
}
