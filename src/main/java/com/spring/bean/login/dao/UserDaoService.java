package com.spring.bean.login.dao;

import java.util.List;

import com.hibernate.model.UserModel;

public interface UserDaoService {
    public int insertOne(String name);
    public List<UserModel> getById(int _id);
    public List<UserModel> getAll();
    public int updateById(int _id, String _name);
    public int deleteById(int _id);
}
