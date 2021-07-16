package com.example.officeProductSelector.dao;

import com.example.officeProductSelector.model.User;

import java.util.List;

public interface UserDao {
    List<User> getByLogin(String login);
    void saveProduct(User user);
    List<User> getByLoginAndPassword(String login, String password);
}
