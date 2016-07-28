package com.action.freemark;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    Map<String, String> myMap;
    
    public IndexAction() {
        myMap = new HashMap<String, String>();
    }
    
    public Map<String, String> getMyMap() {
        return myMap;
    }
    
    public String execute() {
        myMap.put("id", "1");
        myMap.put("name", "me");
        System.out.println(myMap);
        
        return SUCCESS;
    }
}
