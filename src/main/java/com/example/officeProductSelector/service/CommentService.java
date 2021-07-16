package com.example.officeProductSelector.service;

import com.example.officeProductSelector.model.Comment;
import com.example.officeProductSelector.model.Product;

import java.util.List;

public interface CommentService {
    List<Comment> getByProductId(Product product);
    void saveComment(Comment comment);
}
