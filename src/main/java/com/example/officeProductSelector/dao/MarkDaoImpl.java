package com.example.officeProductSelector.dao;

import com.example.officeProductSelector.model.Mark;
import com.example.officeProductSelector.model.Product;
import com.example.officeProductSelector.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MarkDaoImpl implements MarkDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Mark> getMarkByUserAndProductId(int userId, int productId){
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Mark> cq = cb.createQuery(Mark.class);
        Root<Mark> root = cq.from(Mark.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("user_id"), userId));
        predicates.add(cb.equal(root.get("product_id"), productId));
        cq.select(root).where(predicates.toArray(new Predicate[]{}));
        Query<Mark> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Mark> getMarksByProductId(int productId){
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Mark> cq = cb.createQuery(Mark.class);
        Root<Mark> root = cq.from(Mark.class);
        cq.select(root).where(cb.equal(root.get("product_id"), productId));
        Query<Mark> query = session.createQuery(cq);
        return query.getResultList();
    }
}
