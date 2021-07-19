package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.MarkDao;
import com.example.officeProductSelector.model.Mark;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;
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
    public List<Mark> getMarkByUserAndProductId(User user, Product product) {
        return markDao.getMarkByUserAndProductId(user, product);
    }

    @Override
    @Transactional
    public List<Mark> getMarksByProductId(Product product) {
        return markDao.getMarksByProductId(product);
    }

    @Override
    @Transactional
    public void saveMark(Mark mark){
        markDao.saveMark(mark);
    }
}
