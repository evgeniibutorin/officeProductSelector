package com.example.officeProductSelector.controller;

import com.example.officeProductSelector.model.Comment;
import com.example.officeProductSelector.model.Mark;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;
import com.example.officeProductSelector.service.CommentService;
import com.example.officeProductSelector.service.MarkService;
import com.example.officeProductSelector.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    public MainController(ProductService productService, CommentService commentService, MarkService markService) {
        this.productService = productService;
        this.commentService = commentService;
        this.markService = markService;
    }

    private ProductService productService;
    private CommentService commentService;
    private MarkService markService;

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
                          ModelMap modelMap) {
        int currentPage = Integer.parseInt(currentPageFromVue);
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
        return "product_list";
    }

    @GetMapping("/rating")
    @ResponseBody
    public Double getRating(@RequestParam String mark,
                          @RequestParam String productIdFromVue,
                          HttpServletRequest request) {
//        System.out.println("Данные с фронта " + mark);
//        System.out.println("Данные с фронта " + productIdFromVue);
        User user = (User) request.getSession().getAttribute("user");
        int userID = user.getId();
        int productId = Integer.parseInt(productIdFromVue);
        Product product = productService.getProductById(productId);
        System.out.println("Проверка "+product.getName());
        List<Mark> marks = markService
                .getMarkByUserAndProductId(user, product);
        System.out.println(marks.size());
        if (!(marks == null
                || marks.isEmpty())){
            Mark appdataMark = marks.get(0);
            appdataMark.setMark(Integer.parseInt(mark));
            markService.saveMark(appdataMark);
        }
        else {
            Mark newMark = new Mark();
            newMark.setMark(Integer.parseInt(mark));
            newMark.setProduct(productService.getProductById(productId));
            newMark.setUser(user);
            markService.saveMark(newMark);
        }
        List<Mark> allMarks = markService.getMarksByProductId(product);
        double totalScore = 0;
        for (Mark oneMark : allMarks) {
            totalScore = totalScore+oneMark.getMark();
        }
        Double total = totalScore/allMarks.size();
        return total;
    }


}