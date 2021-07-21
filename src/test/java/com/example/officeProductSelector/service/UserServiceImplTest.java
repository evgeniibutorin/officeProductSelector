package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.UserDao;
import com.example.officeProductSelector.model.Status;
import com.example.officeProductSelector.model.User;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration({"file:src/test/resources/spring-mvc-crud-demo-servlet.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Test
    public void saveUser() {
    }

    @Test
    public void getUserByLoginAndPassword() {
    }

    @Test
    public void getByLogin() {
        User expectedUser = new User();
        expectedUser.setId(0);
        expectedUser.setName("Admin");
        expectedUser.setLogin("a");
        expectedUser.setPassword("a");
        expectedUser.setStatus(Status.ADMIN);
//        List<User> users1 = userDao.getByLogin("q");
//        System.out.println(users1.size());
        List<User> users = userService.getByLogin("a");
        users.size();
        List<User> allUsers = userService.getUsers();
        System.out.println(allUsers.size());
        Assert.assertEquals(expectedUser, users.get(0));
    }
}