package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.spring.bean.Initialized;


public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        
        //load properties
        Initialized initializedBean = (Initialized)applicationContext.getBean("initialized");
        servletContext.setAttribute("defaultUserName", initializedBean.getGlobalSitting().get("User.Name"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

}
