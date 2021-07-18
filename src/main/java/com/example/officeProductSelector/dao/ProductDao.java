package com.example.officeProductSelector.dao;

import com.example.officeProductSelector.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> paginProductList(int currentPage, int recordsPerPage);
    Long getNumberOfRows();
    List<Product> getAllProducts();
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    Product getProduct(int id);
}
