package com.coforge.dao;

import java.util.List;

import com.coforge.entities.Orders;

public interface OrderDaoInterface {
	public List<Orders>getAllOrdersList();
    
    void insertOrder(Orders order);
 
    void updateOrder(Orders order);
 
    void deleteOrder(Orders order);
 
    Orders getById(int id);

	

}
