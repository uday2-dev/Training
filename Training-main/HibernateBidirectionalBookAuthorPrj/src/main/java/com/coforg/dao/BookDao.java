package com.coforg.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.coforg.entities.Author;
import com.coforg.entities.Book;
import com.coforge.Util.HibernateUtil;

public class BookDao {
	public void getAll()
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			// HQL uses the entity class name (case-sensitive)
			session.createQuery("from Book", Book.class).list().forEach(e->System.out.println(e));
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public void saveBook(Book book)
	{
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			Transaction txTransaction = session.beginTransaction();
			session.persist(book);
			txTransaction.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public Book getBookById(long bid)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			//Transaction txTransaction = session.beginTransaction();
			return  session.get(Book.class, bid);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}