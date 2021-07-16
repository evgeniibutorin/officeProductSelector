package com.example.officeProductSelector.dao;

import com.example.officeProductSelector.model.Comment;
import com.example.officeProductSelector.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public List<Comment> getByProductId(Integer productId) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
        Root<Comment> root = cq.from(Comment.class);
        cq.select(root).where(cb.equal(root.get("product_id"), productId));
        Query<Comment> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveComment(Comment comment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(comment);
    }

}
