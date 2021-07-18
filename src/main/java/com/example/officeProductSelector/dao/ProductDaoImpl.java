package com.example.officeProductSelector.dao;

import com.example.officeProductSelector.model.Product;
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
public class ProductDaoImpl implements ProductDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        Query<Product> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveProduct(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        }
    }

    @Override
    public Product getProduct(int id) {
        return this.sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public Long getNumberOfRows(){
        Integer numOfRows = 0;
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder qb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(Product.class)));
        return session.createQuery(cq).getSingleResult();
    }



    @Override
    public List<Product> paginProductList(int currentPage, int recordsPerPage){

        int start = currentPage * recordsPerPage - recordsPerPage;
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        Query<Product> query = session.createQuery(cq);
        return query.setFirstResult(start).setMaxResults(recordsPerPage).getResultList();
    }
}
