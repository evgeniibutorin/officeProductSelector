package com.example.officeProductSelector.dao;

import com.example.officeProductSelector.model.Mark;

import java.util.List;

public interface MarkDao {

    List<Mark> getMarkByUserAndProductId(int userId, int productId);
    List<Mark> getMarksByProductId(int productId);
}
