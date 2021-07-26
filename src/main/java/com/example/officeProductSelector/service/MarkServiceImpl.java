package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.MarkDao;
import com.example.officeProductSelector.dao.ProductDao;
import com.example.officeProductSelector.model.Mark;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService{

    MarkDao markDao;
    ProductDao productDao;

    public MarkServiceImpl(MarkDao markDao, ProductDao productDao) {
        this.markDao = markDao;
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public Double totalMark(User user, Product product, String mark){
        List<Mark> marks = markDao.getMarkByUserAndProductId(user, product);
        if (!(marks == null || marks.isEmpty())){
            Mark appdataMark = marks.get(0);
            appdataMark.setMark(Integer.parseInt(mark));
            markDao.saveMark(appdataMark);
        }
        else {
            Mark newMark = new Mark();
            newMark.setMark(Integer.parseInt(mark));
            newMark.setProduct(product);
            newMark.setUser(user);
            markDao.saveMark(newMark);
        }
        List<Mark> allMarks = markDao.getMarksByProductId(product);
        double totalScore = 0;
        for (Mark oneMark : allMarks) {
            totalScore = totalScore+oneMark.getMark();
        }
        Double total = totalScore/allMarks.size();
        return total;
    }
}
