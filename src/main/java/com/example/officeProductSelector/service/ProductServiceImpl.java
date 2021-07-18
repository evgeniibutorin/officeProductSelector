package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.ProductDao;
import com.example.officeProductSelector.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public Product getProductById(int id){
        return productDao.getProduct(id);
    }

    @Override
    @Transactional
    public List<Product> findAllProducts(){
        return productDao.getAllProducts();
    }

    @Override
    @Transactional
    public void updateProduct(Product product){
        productDao.updateProduct(product);
    }

    @Override
    @Transactional
    public void saveProduct(Product product){
        productDao.saveProduct(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id){
        productDao.deleteProduct(id);
    }

    @Override
    @Transactional
    public Long getNumberOfRows(){
        return productDao.getNumberOfRows();
    }

    @Override
    @Transactional
    public List<Product> paginProductList(int currentPage, int recordsPerPage){
        return productDao.paginProductList(currentPage, recordsPerPage);
    }




}
