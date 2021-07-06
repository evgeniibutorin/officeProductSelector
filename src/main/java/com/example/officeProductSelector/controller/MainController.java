package com.example.officeProductSelector.controller;

import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    ProductService productService;

    @GetMapping("/product_page")
    public String getProductsPage() {
        return "product_page";
    }

    @GetMapping("/product_change_page")
    public String getProductsChangePage() {
        return "product_change_page";
    }

    @GetMapping("/new")
    public String getFormPage() {
        return "product_change_page";
    }

    @GetMapping("/list")
    public String get() {
        return "admin_product_list";
    }

    @PostMapping("/insert")
    public String saveProduct(@RequestParam String name, @RequestParam String description, ModelMap productModel) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        productService.saveProduct(product);
        List<Product> products = productService.findAllProducts();
        productModel.addAttribute("products", products);
        return "admin_product_list";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestParam int id, @RequestParam String name, @RequestParam String description, ModelMap productModel) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        productService.updateProduct(product);
        List<Product> products = productService.findAllProducts();
        productModel.addAttribute("products", products);
        return "admin_product_list";
    }
    @GetMapping("delete")
    public String deleteProduct(@RequestParam int id, ModelMap productModel){
        productService.deleteProduct(id);
        List<Product> products = productService.findAllProducts();
        productModel.addAttribute("products", products);
        return "admin_product_list";
    }




}