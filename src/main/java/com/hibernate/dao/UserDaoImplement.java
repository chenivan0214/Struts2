package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.UserModel;

public class UserDaoImplement implements UserDao {
    private SessionFactory sessionFactory;
    
    public UserDaoImplement(SessionFactory _sessionFactory) {
        sessionFactory = _sessionFactory;
    }
    
    @Override
    public int insertOne(String _name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result = 0;
        
        try {
            transaction = session.beginTransaction();
            Query query = session
                          .createSQLQuery("insert into user(name) values (:name)")
                          .addEntity(UserModel.class)
                          .setParameter("name", _name);
            result = query.executeUpdate();
        }  catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            transaction.commit();session.close();
        }
        
        return result;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<UserModel> getById(int _id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<UserModel> listUserModel = null;
        
        try {
            transaction = session.beginTransaction();
            Query query = session
                          .createSQLQuery("select * from user where id=:id")
                          .addEntity(UserModel.class)
                          .setParameter("id", _id);
            
            listUserModel = query.list();
        } catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            transaction.commit();session.close();
        }
        
        return listUserModel;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserModel> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<UserModel> listUserModel = null;
        
        try {
            transaction = session.beginTransaction();
            Query query = session
                          .createSQLQuery("select * from user")
                          .addEntity(UserModel.class);
            listUserModel = query.list();
        } catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            transaction.commit();session.close();
        }
        
        return listUserModel;
    }

    @Override
    public int updateById(int _id, String _name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result = 0;
        
        try {
            transaction = session.beginTransaction();
            Query query = session
                          .createSQLQuery("Update user set name=:name where id=:id")
                          .addEntity(UserModel.class)
                          .setParameter("id", _id)
                          .setParameter("name", _name);
            result = query.executeUpdate();
        }  catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            transaction.commit();session.close();
        }
        
        return result;
    }

    @Override
    public int deleteById(int _id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        int result = 0;
        
        try {
            transaction = session.beginTransaction();
            Query query = session
                          .createSQLQuery("delete from user where id=:id")
                          .addEntity(UserModel.class)
                          .setParameter("id", _id); 
            result = query.executeUpdate();
        }  catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            transaction.commit();session.close();
        }
        
        return result;
    }
}
