package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.UserDao;
import com.example.officeProductSelector.model.Status;
import com.example.officeProductSelector.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
//        createAdmin();
    }

//    @PostConstruct
    @PostConstruct
    public void createAdmin(){
//        userDao.getUsers();
            User admin = new User();
            admin.setName("Admin");
            admin.setLogin("a");
            admin.setPassword("a");
            admin.setStatus(Status.ADMIN);
            userDao.save(admin);
    }


    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public List<User> getUserByLoginAndPassword(String login, String password) {
        return userDao.getByLoginAndPassword(login, password);
    }

    @Override
    @Transactional
    public List<User> getByLogin(String login){
        return userDao.getByLogin(login);
    }

    @Override
    @Transactional
    public List<User> getUsers(){
        return userDao.getUsers();
    }

}
