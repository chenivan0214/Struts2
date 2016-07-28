package com.spring.action.login;

import java.util.HashMap;
import java.util.Map;

public class freemarkAction {
    private Map<String, String> myMap;
    
    public freemarkAction() {
        myMap = new HashMap<String, String>();
    }
    
    public Map<String, String> getMyMap() {
        return myMap;
    }
    
    public String execute() {
        myMap.put("id", "1");
        myMap.put("name", "me");
        System.out.println(myMap);
        
        return "success";
    }
}
