package com.example.officeProductSelector.dao;

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
public class UserDaoImpl implements UserDao{

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<User> getByLoginAndPassword(String login, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("login"), login));
        predicates.add(cb.equal(root.get("password"), password));
        cq.select(root).where(predicates.toArray(new Predicate[]{}));
        Query<User> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<User> getByLogin(String login) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root).where(cb.equal(root.get("login"), login));
        Query<User> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveProduct(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }
}
