package com.coforge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coforge.beans.Employee;
import com.coforge.beans.Hellobeans;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //Hellobeans hbean = new Hellobeans();
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Emp-bean.xml");
//        Hellobeans hbean= (Hellobeans)context.getBean("hello");
//        hbean.sayhello();
//        hbean.printname();
        
        Employee employee = (Employee)context.getBean("emp");
        System.out.println(employee);
        
        
    }
}
