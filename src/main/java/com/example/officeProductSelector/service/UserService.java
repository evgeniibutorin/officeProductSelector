package com.example.officeProductSelector.service;

import com.example.officeProductSelector.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    List<User> getByLogin(String login);
    void saveUser(User user);
    List<User> getUserByLoginAndPassword(String login, String password);
}
