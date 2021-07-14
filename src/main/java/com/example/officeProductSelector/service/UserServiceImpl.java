package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.UserDao;
import com.example.officeProductSelector.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveProduct(user);
    }

    @Override
    @Transactional
    public User getUserByLoginAndPassword(String login, String password) {
        return userDao.getByLoginAndPassword(login, password);
    }

    @Override
    @Transactional
    public List<User> getByLogin(String login){
        return userDao.getByLogin(login);
    }

}
