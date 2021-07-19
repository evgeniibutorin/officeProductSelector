package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.MarkDao;
import com.example.officeProductSelector.model.Mark;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService{

    MarkDao markDao;

    public MarkServiceImpl(MarkDao markDao) {
        this.markDao = markDao;
    }

    @Override
    @Transactional
    public List<Mark> getMarkByUserAndProductId(int userId, int productId) {
        return markDao.getMarkByUserAndProductId(userId, productId);
    }

    @Override
    @Transactional
    public List<Mark> getMarksByProductId(int productId) {
        return markDao.getMarksByProductId(productId);
    }
}
