package com.example.officeProductSelector.controller;

import com.example.officeProductSelector.components.ActiveUser;
import com.example.officeProductSelector.model.User;
import com.example.officeProductSelector.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @GetMapping("/authorization")
    public String getAuthorizationPage() {
        return "login";
    }


    @PostMapping("/authorization")
    public String saveProduct(@RequestParam String login,
                              @RequestParam String password,
                              ModelMap productModel) {
        User user = userService.getUserByLoginAndPassword(login, password);
        if (user != null) {
            ActiveUser activeUser = applicationContext.getBean(ActiveUser.class);
            activeUser.setUser(user);
            activeUser.setActive(true);
        }

        return "product_list";
    }

    @PostMapping("/registration")
    public String updateProduct(@RequestParam String name,
                                @RequestParam String login,
                                @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        userService.saveUser(user);
        return "registration";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
