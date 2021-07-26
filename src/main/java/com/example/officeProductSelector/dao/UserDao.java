package com.example.officeProductSelector.dao;

import com.example.officeProductSelector.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    List<User> getByLogin(String login);
    void save(User user);
    List<User> getByLoginAndPassword(String login, String password);
    List<User> getUsersByName(String name);
    List<User> deleteStudentAndReturnLost(int id);
}
