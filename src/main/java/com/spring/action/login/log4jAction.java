package com.spring.action.login;

import org.apache.log4j.Logger;

public class log4jAction {
    //log4j
    private static final Logger logger = Logger.getLogger(log4jAction.class);
    
    public String execute() {
        if (logger.isDebugEnabled()) {
            System.out.println("d");
            logger.debug("execute()!");
        }
        
        // logs exception
        //logger.error("This is Error message", new Exception("Testing"));
        
        return "success";
    }
}
