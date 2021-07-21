package com.example.officeProductSelector.service;

import com.example.officeProductSelector.model.Status;
import com.example.officeProductSelector.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration({"file:src/test/resources/spring-mvc-crud-demo-servlet.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    private User expectedUser;

    @Before
    public void setUp() {
        expectedUser = new User();
        expectedUser.setId(0);
        expectedUser.setName("Admin");
        expectedUser.setLogin("a");
        expectedUser.setPassword("a");
        expectedUser.setStatus(Status.ADMIN);
    }

    @Test
    @Transactional
    public void saveUser() {
        User user = new User();
        user.setName("z");
        user.setLogin("z");
        user.setPassword("z");
        user.setStatus(Status.USER);
        userService.saveUser(user);
        List<User> users = userService.getUserByLoginAndPassword("z", "z");
        Assert.assertEquals(user, users.get(0));
    }

    @Test
    public void getUserByLoginAndPassword() {
        List<User> users = userService.getUserByLoginAndPassword("a", "a");
        Assert.assertEquals(expectedUser, users.get(0));
    }

    @Test
    public void getByLogin() {
        List<User> users = userService.getByLogin("a");
        List<User> allUsers = userService.getUsers();
        System.out.println(allUsers.size());
        Assert.assertEquals(expectedUser, users.get(0));
    }

    @Test
    public void getUsers() {
        List<User> users = userService.getUsers();
        Assert.assertEquals(2, users.size());
    }
}