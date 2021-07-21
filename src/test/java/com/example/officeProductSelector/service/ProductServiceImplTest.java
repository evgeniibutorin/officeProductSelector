package com.example.officeProductSelector.service;

import com.example.officeProductSelector.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@ContextConfiguration({"file:src/test/resources/spring-mvc-crud-demo-servlet.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    public void getProductById() {
        Product product = new Product();
        product.setId(1);
        product.setDescription("good");
        product.setLogo("");
        product.setName("chocolate");
        productService.getProductById(1);
        Product product1 = productService.getProductById(1);
        Assert.assertEquals(product1,product);
    }

    @Test
    public void updateProduct() {
    }

    @Test
    public void saveProduct() {
    }

    @Test
    public void deleteProduct() {
    }

    @Test
    public void getNumberOfRows() {
    }

    @Test
    public void paginProductList() {
    }
}