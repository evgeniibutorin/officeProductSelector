package com.example.officeProductSelector.service;

import com.example.officeProductSelector.dao.MarkDao;
import com.example.officeProductSelector.model.Mark;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MarkServiceImplTest {

    private MarkDao markDaoMock;

    @Autowired
    private MarkDao markDao;

    @Before
    public void setUp() {
        markDaoMock = Mockito.mock(MarkDao.class);
    }

    User user = new User();
    Product product = new Product();

    @Test
    public void totalMark() {
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

    @Test
    public void totalMarkIfListIsNotEmptyTest() {
        Mark mark = new Mark();
        List<Mark> completedList = new ArrayList<>();
        completedList.add(mark);
        Mockito.when(markDaoMock.getMarkByUserAndProductId(user, product)).thenReturn(completedList);
        List<Mark> marks = markDaoMock.getMarkByUserAndProductId(user, product);
        Mark appdataMark;
        if (!(marks == null || marks.isEmpty())) {
            appdataMark = Mockito.mock(Mark.class);
            appdataMark.setMark(4);
            markDaoMock.saveMark(appdataMark);
        } else {
            appdataMark = Mockito.mock(Mark.class);
            appdataMark.setMark(Integer.parseInt("4"));
            appdataMark.setProduct(product);
            appdataMark.setUser(user);
            markDaoMock.saveMark(appdataMark);
        }
        Mockito.verify(appdataMark, Mockito.atLeast(1)).setMark(4);
    }

    @Test
    public void totalMarkIfListIsEmptyTest() {
        List<Mark> completedList = new ArrayList<>();
        Mockito.when(markDaoMock.getMarkByUserAndProductId(user, product)).thenReturn(completedList);
        List<Mark> marks = markDaoMock.getMarkByUserAndProductId(user, product);
        Mark appdataMark;
        if (!(marks == null || marks.isEmpty())) {
            appdataMark = Mockito.mock(Mark.class);
            appdataMark.setMark(4);
            markDaoMock.saveMark(appdataMark);
        } else {
            appdataMark = Mockito.mock(Mark.class);
            appdataMark.setMark(Integer.parseInt("4"));
            appdataMark.setProduct(product);
            appdataMark.setUser(user);
            markDaoMock.saveMark(appdataMark);
        }
        Mockito.verify(appdataMark, Mockito.atLeast(0)).setMark(4);
    }
}