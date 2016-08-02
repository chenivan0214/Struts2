package com.servlet.dao;

import java.util.List;

import com.hibernate.model.UserModel;

public interface UserDao {
    public List<UserModel> getAll();
}
