package com.example.officeProductSelector.service;

import com.example.officeProductSelector.model.Mark;

import java.util.List;

public interface MarkService {
    List<Mark> getMarkByUserAndProductId(int userId, int productId);
    List<Mark> getMarksByProductId(int productId);
}
