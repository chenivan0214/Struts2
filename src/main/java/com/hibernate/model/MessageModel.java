package com.hibernate.model;

public class MessageModel {
    private int id;
    private int userId;
    private String text;
    
    public int getId() {
        return id;
    }
 
    public void setId(int _id) {
        this.id = _id;
    }
    
    public int getUserId() {
        return userId;
    }
 
    public void setUserId(int _userId) {
        this.userId = _userId;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String _text) {
        text = _text;
    }
}