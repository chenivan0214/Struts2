package com.spring.bean;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

public class UseServletContext {
    public String getAttribute(String _param) {
        ServletContext servletContext = (ServletContext)ServletActionContext.getServletContext();
        return (String)servletContext.getAttribute(_param);
    }
}
