//package com.coforge.dao;
//
//import java.util.List;
//
//import org.hibernate.Session;
//
//import com.coforge.entities.Item;
//import com.coforge.entities.Orders;
//import com.coforge.utils.HibernateUtil;
//
//public class OrderDao implements OrderDaoInterface{
//	@Override
//	public List<Orders> getAllOrdersList() {
//		try(Session session = HibernateUtil.getSessionFactory().openSession())
//		{
//			  return session.createQuery("from Orders", Orders.class).list();
//		}
//		
//	}
//
//
//	
//
//}
package com.coforge.dao;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.coforge.entities.Orders;
import com.coforge.utils.HibernateUtil;
 
public class OrderDao implements OrderDaoInterface {
 
    @Override
    public List<Orders> getAllOrdersList() {
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
 
            return session.createQuery("from Orders", Orders.class).list();
 
        }
    }
 
    @Override
    public void insertOrder(Orders order) {
 
        Transaction tx = null;
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
 
            tx = session.beginTransaction();
 
            session.persist(order);
 
            tx.commit();
        }
        catch(Exception e) {
 
            if(tx != null) tx.rollback();
 
            throw e;
        }
    }
 
    @Override
    public void updateOrder(Orders order) {
 
        Transaction tx = null;
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
 
            tx = session.beginTransaction();
 
            session.merge(order);
 
            tx.commit();
        }
        catch(Exception e) {
 
            if(tx != null) tx.rollback();
 
            throw e;
        }
    }
 
    @Override
    public void deleteOrder(Orders order) {
 
        Transaction tx = null;
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
 
            tx = session.beginTransaction();
 
            session.remove(order);
 
            tx.commit();
        }
        catch(Exception e) {
 
            if(tx != null) tx.rollback();
 
            throw e;
        }
    }
 
    @Override
    public Orders getById(int id) {
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
 
            return session.get(Orders.class, id);
 
        }
    }
}