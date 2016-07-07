package com.action.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    private String type;
    
    //@Override
    //public String execute() throws Exception {
    //    return ActionSupport.SUCCESS;
    //}
    
    public void setType(String _type) {
        type = _type;
    }
    
    public String getType() {
        return type;
    }
    
    public String index() {
        System.out.println(getType());
        //HttpServletRequest req = ServletActionContext.getRequest();
        //String type = req.getParameter("type");
        //System.out.println(req.getParameter("type"));
        ActionContext.getContext().getSession().put("type", getType());
        
        return "index_success";
    }
    
    public String after() {
        return "after_success";
    }
}
