package com.coforge.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coforg.entities.Author;
import com.coforg.entities.Book;


public class HibernateUtil {

   private static final SessionFactory sessionFactory = buildSessionFactory();

   private static SessionFactory buildSessionFactory() {
       try {
           Properties properties = new Properties();
           InputStream inputStream = HibernateUtil.class.getClassLoader()
                   .getResourceAsStream("application.properties");

           if (inputStream == null) {
               throw new RuntimeException("application.properties not found in src/main/resources!");
           }

           properties.load(inputStream);

           Configuration configuration = new Configuration();
           configuration.setProperties(properties);

           configuration.addAnnotatedClass(Book.class);
           configuration.addAnnotatedClass(Author.class);

           return configuration.buildSessionFactory();

       } catch (IOException e) {
           e.printStackTrace();
           throw new RuntimeException("Failed to load application.properties", e);
       }
   }

   public static SessionFactory getSessionFactory() {
       return sessionFactory;
   }
}