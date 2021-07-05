package com.example.officeProductSelector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/product_page")
    public String getProductsPage() {
        return "product_page";
    }

    @GetMapping("/product_change_page")
    public String getProductsChangePage() {
        return "product_change_page";
    }

}
