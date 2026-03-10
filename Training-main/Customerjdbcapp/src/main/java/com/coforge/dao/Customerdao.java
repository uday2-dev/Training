package com.coforge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.coforge.entities.Customer;
import com.coforge.utils.Dbutils;
public class Customerdao {
	// crud operations
	
	public  List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException
	{
		List<Customer>custlist = new ArrayList<Customer>();
		String queryString = "select * from customer";
		Connection connection = Dbutils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(queryString);
		
		
		while(rSet.next())
		{
			Customer customer = new Customer();
			customer.setCustid(rSet.getLong("custId"));
			customer.setCustname(rSet.getString("custname"));
			customer.setAddress(rSet.getString("address"));
			customer.setEmail(rSet.getString("email"));
			customer.setMobile(rSet.getString("mobile"));
			custlist.add(customer);
			
		}
		rSet.close();
		statement.close();
		connection.close();
		return custlist;
		
	}
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException
	{
		Connection connection = Dbutils.getConnection();
		String queryString = " insert into customer values (?,?,?,?,?)";
		PreparedStatement pStatement  = connection.prepareStatement(queryString);
		pStatement.setLong(1,customer.getCustid());
		pStatement.setString(2,customer.getCustname());
		pStatement.setString(3,customer.getAddress());
		pStatement.setString(4,customer.getEmail());
		pStatement.setString(5,customer.getMobile());
		pStatement.executeUpdate();
		pStatement.close();
		connection.close();
		return "Customer added successfully";
		
	}
	public Customer getCustomerById(long custId) throws ClassNotFoundException, SQLException
	{
		Connection connection = Dbutils.getConnection();
		String queryString = "select * from customer where custid=?";
		PreparedStatement pStatement = connection.prepareStatement(queryString);
		pStatement.setLong(1, custId);
		ResultSet rSet = pStatement.executeQuery();
		Customer customer = new Customer();
		
		while(rSet.next())
		{
			 customer = new Customer();
			customer.setCustid(rSet.getLong("custId"));
			customer.setCustname(rSet.getString("custname"));
			customer.setAddress(rSet.getString("address"));
			customer.setEmail(rSet.getString("email"));
			customer.setMobile(rSet.getString("mobile"));
		}
		return customer;
		
		
	}
}
