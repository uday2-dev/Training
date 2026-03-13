package com.coforge;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.beans.Customer;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext  context = new ClassPathXmlApplicationContext("Customer-bean-injection.xml");
        Customer customer = (Customer)context.getBean("customer");
        System.out.println(customer);
        ApplicationContext  context1 = new ClassPathXmlApplicationContext("Customer-bean-auto.xml");
        Customer customer2 = (Customer)context1.getBean("customer2");
        System.out.println(customer2);
    }
}
