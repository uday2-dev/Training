package com.coforge.springframworkannotations;

import com.coforge.beans.Book;
import com.coforge.beans.Order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Book-bean.xml");
        Book book = (Book)context.getBean("book");
        System.out.println(book);
        
        Order order = (Order)context.getBean("order");
        System.out.println(order);
    }
}