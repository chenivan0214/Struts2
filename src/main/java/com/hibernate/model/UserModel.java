package com.hibernate.model;

public class UserModel {
    private int id;
    private String name;
    
    public int getId() {
        return id;
    }
 
    public void setId(int _id) {
        this.id = _id;
    }
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}