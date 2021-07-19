package com.example.officeProductSelector.service;

import com.example.officeProductSelector.model.Mark;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;

import java.util.List;

public interface MarkService {
    List<Mark> getMarkByUserAndProductId(User user, Product product);
    List<Mark> getMarksByProductId(Product product);
    void saveMark(Mark mark);
}
