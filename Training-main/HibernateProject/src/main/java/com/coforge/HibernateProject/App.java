package com.coforge.HibernateProject;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.coforge.dao.ItemDao;
import com.coforge.dao.OrderDao;
import com.coforge.entities.Item;
import com.coforge.entities.Orders;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
       ItemDao itemDao = new ItemDao();
       itemDao.getAllItems().forEach(item->System.out.println(item));
       OrderDao orderDao = new OrderDao();
       orderDao.getAllOrdersList().forEach(ord->System.out.println(ord));
    
       Orders order=new Orders(1, LocalDate.now(), "Uday");
       orderDao.insertOrder(order);
       orderDao.getAllOrdersList().forEach(System.out::println);
       Orders o=orderDao.getById(1);
       System.out.println(o);
      
    }
}