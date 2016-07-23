package com.hibernate.dao;

import java.util.List;

import com.hibernate.model.UserModel;

public interface UserDao {
    public List<UserModel> getById(int _id);
    public List<UserModel> getAll();
    public int insertOne(String _name);
    public int updateById(int _id, String _name);
    public int deleteById(int _id);
}
