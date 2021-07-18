package com.example.officeProductSelector.controller;

import com.example.officeProductSelector.model.Comment;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;
import com.example.officeProductSelector.service.CommentService;
import com.example.officeProductSelector.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    public MainController(ProductService productService, CommentService commentService) {
        this.productService = productService;
        this.commentService = commentService;
    }

    private ProductService productService;
    private CommentService commentService;

    @GetMapping("/product_page")
    public String getProductsPage() {
        return "product_page";
    }

    @GetMapping("/list")
    public String get(ModelMap productModel) {
        List<Product> products = productService.findAllProducts();
        productModel.addAttribute("products", products);
        return "product_list";
    }

//    @GetMapping("/admlist")
//    public String getAdminList(ModelMap productModel) {
//        List<Product> products = productService.findAllProducts();
//        productModel.addAttribute("products", products);
//        return "admin_product_list";
//    }


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


    @GetMapping("/pglist")
    public String getList(@RequestParam String currentPageFromVue,
//                          @RequestParam String recordsPerPageFromVue,
                          ModelMap modelMap) {
//        Long l = productService.getNumberOfRows();
//        System.out.println("Вывод в консоль " + l.toString());
        int currentPage = Integer.parseInt(currentPageFromVue);
//        int recordsPerPage = Integer.parseInt(recordsPerPageFromVue);
        int recordsPerPage = 5;
        List<Product> products = productService.paginProductList(currentPage, recordsPerPage);
        modelMap.addAttribute("products", products);
        int rows = Math.toIntExact(productService.getNumberOfRows());
        int nOfPages = rows / recordsPerPage;
        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }
        modelMap.addAttribute("noOfPages", nOfPages);
        modelMap.addAttribute("currentPage", currentPage);
//        modelMap.addAttribute("recordsPerPage", recordsPerPage);
        return "product_list";
    }


}