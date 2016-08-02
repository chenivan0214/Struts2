package com.servlet.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.UserModel;
import com.utility.common.HibernateUtility;

public class UserDaoImplement implements UserDao {

    @Override
    public List<UserModel> getAll() {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        
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
            transaction.commit();
            session.close();
        }
        
        return listUserModel;
    }

}
