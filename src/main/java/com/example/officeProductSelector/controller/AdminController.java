package com.example.officeProductSelector.controller;

import com.example.officeProductSelector.model.Product;
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

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/main/admin")
public class AdminController {

    private ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/new")
    public String getFormPage() {
        return "product_change_page";
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
        int currentPage = 1;
        int recordsPerPage = 5;
        List<Product> products = productService.paginProductList(currentPage, recordsPerPage);
        productModel.addAttribute("products", products);
        int rows = Math.toIntExact(productService.getNumberOfRows());
        int nOfPages = rows / recordsPerPage;
        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }
        productModel.addAttribute("noOfPages", nOfPages);
        productModel.addAttribute("currentPage", currentPage);
        return "product_list";
    }

    @PostMapping("/update")
    public String updateProduct(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String description,
                                @RequestParam(required = false) String doChange,
                                @RequestParam MultipartFile file,
                                ModelMap productModel) {

        Product product = productService.getProductById(id);
        product.setName(name);
        product.setDescription(description);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        if ("yes".equals(doChange)) {
            try {
                product.setLogo(Base64.getEncoder().encodeToString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productService.updateProduct(product);
        int currentPage = 1;
        int recordsPerPage = 5;
        List<Product> products = productService.paginProductList(currentPage, recordsPerPage);
        productModel.addAttribute("products", products);
        int rows = Math.toIntExact(productService.getNumberOfRows());
        int nOfPages = rows / recordsPerPage;
        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }
        productModel.addAttribute("noOfPages", nOfPages);
        productModel.addAttribute("currentPage", currentPage);
        return "product_list";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id, ModelMap productModel) {
        productService.deleteProduct(id);
        int currentPage = 1;
        int recordsPerPage = 5;
        List<Product> products = productService.paginProductList(currentPage, recordsPerPage);
        productModel.addAttribute("products", products);
        int rows = Math.toIntExact(productService.getNumberOfRows());
        int nOfPages = rows / recordsPerPage;
        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }
        productModel.addAttribute("noOfPages", nOfPages);
        productModel.addAttribute("currentPage", currentPage);
        return "product_list";
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam int id, Model product) {
        Product productFromDB = productService.getProductById(id);
        product.addAttribute(productFromDB);
        return "product_change_page";
    }


}


