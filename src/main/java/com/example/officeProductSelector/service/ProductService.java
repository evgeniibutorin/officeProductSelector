package com.example.officeProductSelector.service;

import com.example.officeProductSelector.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> paginProductList(int currentPage, int recordsPerPage);
    Long getNumberOfRows();
    Product getProductById(int id);
    List<Product> findAllProducts();
    void updateProduct(Product product);
    void saveProduct(Product product);
    void deleteProduct(int id);
}
