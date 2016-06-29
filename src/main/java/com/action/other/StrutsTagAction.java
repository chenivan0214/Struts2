package com.action.other;

import com.opensymphony.xwork2.ActionSupport;

public class StrutsTagAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    //@Override
    //public String execute() throws Exception {
    //    return ActionSupport.SUCCESS;
    //}

    public String form() {
        System.out.println("cc");
        return "form_success";
    }
}
