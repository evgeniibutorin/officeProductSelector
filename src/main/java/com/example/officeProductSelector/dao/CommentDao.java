package com.example.officeProductSelector.dao;

import com.example.officeProductSelector.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getByProductId(Integer productId);
    void saveComment(Comment comment);
}
