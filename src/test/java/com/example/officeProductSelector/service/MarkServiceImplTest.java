package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.MarkDao;
import com.example.officeProductSelector.model.Mark;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MarkServiceImplTest {

    private MarkDao markDaoMock;
//    private MarkDao markDao;

    @Before
    public void setUp() {
        markDaoMock = Mockito.mock(MarkDao.class);
    }

    User user = new User();
    Product product = new Product();
    List<Mark> emptyMarkList = new ArrayList<>();

    @Test
    public void totalMark() {
//        Mockito.when(markDaoMock.getMarkByUserAndProductId(user,product)).thenReturn(emptyMarkList);
        List<Mark> marks = markDaoMock.getMarkByUserAndProductId(user, product);
        if (!(marks == null || marks.isEmpty())){
//         TODO: 21.07.2021 Посмотреть что выполняется метод get

            Mark appdataMark = marks.get(0);
            appdataMark.setMark(Integer.parseInt("4"));
            markDaoMock.saveMark(appdataMark);
        }
        else {
            Mark newMark = new Mark();
            newMark.setMark(Integer.parseInt("4"));
            newMark.setProduct(product);
            newMark.setUser(user);
            markDaoMock.saveMark(newMark);
        }

        Mark mark = new Mark();
        mark.setId(0);
        mark.setMark(4);
        mark.setUser(user);
        mark.setProduct(product);
        List<Mark> markList = new ArrayList<>();
        markList.add(mark);
        Mockito.when(markDaoMock.getMarksByProductId(product)).thenReturn(markList);
        List<Mark> allMarks = markDaoMock.getMarksByProductId(product);
        double totalScore = 0;
        for (Mark oneMark : allMarks) {
            totalScore = totalScore + oneMark.getMark();
        }
        Double total = totalScore / allMarks.size();
        Assert.assertEquals(total, 4.0, 0.0);
    }
}