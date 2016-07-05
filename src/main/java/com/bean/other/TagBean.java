package com.bean.other;

import java.security.Timestamp;
import java.util.Date;

public class TagBean {
    private String name;
    
    public TagBean() {
        
    }
    
    public TagBean(String _name) {
        this.name = _name;
    }
    
    public void setName(String _name) {
        System.out.println("1:set " + _name);
        this.name = _name;
    }
    
    public String getName() {
        System.out.println("2:get " + this.name);
        return this.name;
    }
}
