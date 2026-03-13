package com.coforge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coforge.models.Account;

public class Accountdao {
	

	public static  List<Account> getAllAccounts(Connection connection) throws SQLException {
		String queryString ="select * from account";
		try(Statement statement = connection.createStatement();
		ResultSet rSet = statement.executeQuery(queryString)) {
			List<Account>accounts = new ArrayList<Account>();
			while(rSet.next())
			{
				Account accounts1 = new Account();
				accounts1.setAccountnumber(rSet.getInt("accountnumber"));
				accounts1.setAccountholdername(rSet.getString("accountholdername"));
				accounts1.setAccounttype(rSet.getString("accounttype"));
				accounts1.setBalance(rSet.getDouble("balance"));
				accounts.add(accounts1);
			}
			return accounts;
			
		} 
	}
}

