package com.example.officeProductSelector.service;

import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;

public interface MarkService {
    Double totalMark(User user, Product product, String mark);
}
