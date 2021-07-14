package com.example.officeProductSelector.dao;

import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;

public interface UserDao {
    void saveProduct(User user);
    User getByLoginAndPassword(String login, String password);
}
