package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.ProductDao;
import com.example.officeProductSelector.dto.ProductDTO;
import com.example.officeProductSelector.model.Mark;
import com.example.officeProductSelector.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<ProductDTO> paginProductList(int currentPage, int recordsPerPage){
        return setStudentDtoList(productDao.paginProductList(currentPage, recordsPerPage));
    }

    public List<ProductDTO> setStudentDtoList(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            productDTO.setLogo(product.getLogo());
            productDTO.setMarks(product.getMarks());
            Double d = 0.0;
            for (Mark mark : product.getMarks()) {
                d = d+mark.getMark();
            }
            Double result = 0.0;
            if (product.getMarks().size()>0) {
                result = d / product.getMarks().size();
            }
            productDTO.setTotalMark(result);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }




}
