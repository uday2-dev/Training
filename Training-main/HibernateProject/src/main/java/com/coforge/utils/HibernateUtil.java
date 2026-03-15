package com.coforge.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
        Session session = sFactory.openSession();
		return sFactory;
	}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	
	

}
