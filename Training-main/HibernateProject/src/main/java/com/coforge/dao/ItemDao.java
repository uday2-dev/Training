package com.coforge.dao;
 
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.coforge.entities.Item;
import com.coforge.utils.HibernateUtil;
 
public class ItemDao implements ItemDaoInterface {
 
    @Override
    public List<Item> getAllItems() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Item", Item.class).list();
        }
    }
 
    @Override
    public void insertItem(Item item) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(item);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
 
    @Override
    public void updateItem(Item item) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(item); // works for detached entities
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
 
    @Override
    public void deleteItem(Item item) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Item i = session.get(Item.class, 3);
            if (i != null) {
                Transaction txDelete = session.beginTransaction();
                try {
                    session.remove(i);
                    txDelete.commit();
                    System.out.println("Deleted item id=3.");
                } catch (Exception ex) {
                    txDelete.rollback();
                    throw ex;
                }
            }
        }
    }
 
    @Override
    
    public void getById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Item item = session.get(Item.class, id);
            System.out.println(item);
        }
    }
    }