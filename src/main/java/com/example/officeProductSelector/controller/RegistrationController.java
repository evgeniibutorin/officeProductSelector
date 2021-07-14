package com.example.officeProductSelector.controller;

import com.example.officeProductSelector.components.ActiveUser;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;
import com.example.officeProductSelector.service.ProductService;
import com.example.officeProductSelector.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("/main")
public class RegistrationController {
    UserService userService;
    ProductService productService;
//    ActiveUser activeUser;

    public RegistrationController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
//        this.activeUser = activeUser;
    }
    public static String IS_ACTIVE = "isActive";
    public static String USER = "user";

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
                              HttpServletRequest request,
                              ModelMap productModel) {
        User user = userService.getUserByLoginAndPassword(login, password);
        if (user != null) {
            request.getSession().setAttribute(USER, user);
            request.getSession().setAttribute(IS_ACTIVE, true);
//            activeUser.setUser(user);
//            activeUser.setActive(true);
            List<Product> products = productService.findAllProducts();
            productModel.addAttribute("products", products);
            return "product_list";
        }
        else {
            return "registration";}

    }

    @PostMapping("/registration")
    public String updateProduct(@RequestParam String name,
                                @RequestParam String login,
                                @RequestParam String password,
                                HttpServletRequest request) {

        List<User> userFromFB = userService.getByLogin(login);
        if (userFromFB==null||userFromFB.isEmpty()) {
            User user = new User();
            user.setName(name);
            user.setLogin(login);
            user.setPassword(password);
            userService.saveUser(user);
            request.getSession().setAttribute(USER, user);
            request.getSession().setAttribute(IS_ACTIVE, true);
//            activeUser.setUser(user);
//            activeUser.setActive(true);
        }

        else {
            request.getSession().setAttribute(USER, userFromFB.get(0));
            request.getSession().setAttribute(IS_ACTIVE, true);
//            activeUser.setUser(userFromFB);
//            activeUser.setActive(true);
        }
        return "admin_product_list";
    }

    @GetMapping("/logOut")
    public String logOut(HttpServletRequest request) {
        request.getSession().removeAttribute(USER);
        request.getSession().removeAttribute(IS_ACTIVE);
        return "login";
    }

}
