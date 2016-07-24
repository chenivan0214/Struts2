package com.listener;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateServletContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent _servletContextEvent) {
        SessionFactory sessionFactory = (SessionFactory) _servletContextEvent.getServletContext().getAttribute("SessionFactory");
        sessionFactory.close();
    }

    @Override
    public void contextInitialized(ServletContextEvent _servletContextEvent) {
        URL url = HibernateServletContextListener.class.getResource("/hibernate/hibernate.cfg.xml");
        Configuration config = new Configuration();
        config.configure(url);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        _servletContextEvent.getServletContext().setAttribute("SessionFactory", sessionFactory);
    }

}
