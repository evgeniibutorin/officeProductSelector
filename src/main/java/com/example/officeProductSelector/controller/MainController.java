package com.example.officeProductSelector.controller;

import com.example.officeProductSelector.model.Comment;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;
import com.example.officeProductSelector.service.CommentService;
import com.example.officeProductSelector.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    public MainController(ProductService productService, CommentService commentService) {
        this.productService = productService;
        this.commentService = commentService;
    }

    ProductService productService;
    CommentService commentService;

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
    public String get(ModelMap productModel) {
        List<Product> products = productService.findAllProducts();
        productModel.addAttribute("products", products);
        return "product_list";
    }

    @GetMapping("/admlist")
    public String getAdminList(ModelMap productModel) {
        List<Product> products = productService.findAllProducts();
        productModel.addAttribute("products", products);
        return "admin_product_list";
    }

    @PostMapping("/insert")
    public String saveProduct(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "file") MultipartFile file,
            ModelMap productModel) {

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            product.setLogo(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.saveProduct(product);
        List<Product> products = productService.findAllProducts();
        productModel.addAttribute("products", products);
        return "admin_product_list";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String description,
                                @RequestParam MultipartFile file,
                                ModelMap productModel) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            product.setLogo(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        productService.updateProduct(product);
        List<Product> products = productService.findAllProducts();
        productModel.addAttribute("products", products);
        return "admin_product_list";
    }

    @GetMapping("delete")
    public String deleteProduct(@RequestParam int id, ModelMap productModel) {
        productService.deleteProduct(id);
        List<Product> products = productService.findAllProducts();
        productModel.addAttribute("products", products);
        return "admin_product_list";
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam int id, Model product) {
        Product productFromDB = productService.getProductById(id);
        product.addAttribute(productFromDB);
        return "product_change_page";
    }

    @GetMapping("/details")
    public String getProductDetails(@RequestParam int id, Model product) {
        Product productFromDB = productService.getProductById(id);
        product.addAttribute(productFromDB);
        return "product_page";
    }

    @PostMapping("/comment")
    public String postComment(@RequestParam int id,
                              @RequestParam String comment,
                              HttpServletRequest request,
                              Model product) {
        Comment commentToDb = new Comment();
        Product productFromDB = productService.getProductById(id);
        User user = (User) request.getSession().getAttribute("user");
        commentToDb.setComment(comment);
        commentToDb.setProduct(productFromDB);
        commentToDb.setUser(user);
        product.addAttribute(productFromDB);
        commentService.saveComment(commentToDb);
        return "product_page";
    }


}