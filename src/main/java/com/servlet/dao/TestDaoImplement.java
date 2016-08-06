package com.servlet.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.UserModel;
import com.utility.common.HibernateUtility;

public class TestDaoImplement implements TestDao {

    @Override
    public int insert() {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        String sql = null;
        int result = 0;
        
        try {
            transaction = session.beginTransaction();
            //sql = "update User set name = '我我我'";
            sql = "insert into message(user_id, text) values(40, '測試');";
            Query query = session
                          .createSQLQuery(sql)
                          .addEntity(UserModel.class);
            result = query.executeUpdate();
        }  catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            transaction.commit();
            session.close();
        }
        
        return result;
    }
    
    @Override
    public List<?> query() {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        String sql = null;
        List<?> result = null;
        
        try {
            transaction = session.beginTransaction();
            sql = "select User.id, User.name, message.id as messageId, message.text ";
            sql += "from User inner join message ";
            sql += "on User.id = message.user_id ";
            //sql += "where User.id = 40;";
            Query query = session
                          .createSQLQuery(sql);
            
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            result = query.list();
        }  catch (HibernateException e) {
            e.printStackTrace(); 
        } finally {
            transaction.commit();
            session.close();
        }
        
        return result;
    }
}
