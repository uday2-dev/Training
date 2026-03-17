package com.coforg.dao;

import java.util.List;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.coforg.entities.Author;
import com.coforg.entities.Book;
import com.coforge.Util.HibernateUtil;


public class AuthorDao {
	public void getAllAuthors()
	{
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			session.createQuery("from Author", Author.class).list().forEach(a->System.out.println(a));
				
		}
	}
	public void saveAuthor(Author author)
	{
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			Transaction txTransaction = session.beginTransaction();
			session.persist(author);
			txTransaction.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public Author getAuthorById(long aid)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			//Transaction txTransaction = session.beginTransaction();
			return  session.get(Author.class, aid);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void updateAuthor(long aid, String name)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction txTransaction = session.beginTransaction();
			
			Author author = session.get(Author.class, aid);
			if(author!=null)
			{
				author.setName(name);
				session.update(author);
				
			}
			txTransaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void removeBookFromAuthor(long authorid,long bookid)
	{
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			Transaction txTransaction = session.beginTransaction();
			Author author = session.get(Author.class, authorid);
			if(author==null)
			{
				System.out.println("Author not found. no deletion");
				return;
			}
			// Load the book from DB using the session to ensure Hibernate is tracking it
			Book book = session.get(Book.class, bookid);
			if(book==null)
			{
				System.out.println("Book not found in DB. no deletion");
				txTransaction.rollback();
				return;
			}
			// Verify the book belongs to the provided author
			if(book.getAuthor()==null || book.getAuthor().getAuthorid()!=authorid)
			{
				System.out.println("Book not associated with given author. no deletion");
				txTransaction.rollback();
				return;
			}
			// Use helper to remove book from author which handles bidirectional link
			author.removeBook(book);
			// Because CascadeType.ALL with orphanRemoval=true is set on Author.booklist,
			// removing the book from the collection is enough to delete it when the author is saved.
			// But to be explicit and safe, call session.delete on the managed book entity.
			session.delete(book);
			txTransaction.commit();
			System.out.println("Book removed from author and deleted.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void removeAuthor(long authorid)
	{
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			Transaction txTransaction = session.beginTransaction();
			Author author = session.get(Author.class, authorid);
			if(author!=null)
			{
				session.remove(author);;
				txTransaction.commit();
				session.close();
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}