package com.example.officeProductSelector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/product_page")
    public String getStudentStartedPage() {
        return "product_page";
    }

}
