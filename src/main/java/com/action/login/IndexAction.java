package com.action.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    //@Override
    //public String execute() throws Exception {
    //    return ActionSupport.SUCCESS;
    //}
    
    public String index() {
        HttpServletRequest req = ServletActionContext.getRequest();
        System.out.println(req.getParameter("type"));
        return "index_success";
    }
}
