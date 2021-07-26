package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.CommentDao;
import com.example.officeProductSelector.model.Comment;
import com.example.officeProductSelector.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    @Transactional
    public void saveComment(Comment comment) {
        commentDao.saveComment(comment);
    }
}
