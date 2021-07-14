package com.example.officeProductSelector.service;

import com.example.officeProductSelector.model.User;

public interface UserService {

    void saveUser(User user);
    User getUserByLoginAndPassword(String login, String password);
}
