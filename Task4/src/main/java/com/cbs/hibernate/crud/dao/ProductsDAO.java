package com.cbs.hibernate.crud.dao;

import com.cbs.hibernate.crud.models.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProductsDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Products> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Products p", Products.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Products show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Products.class, id);
    }

    @Transactional
    public void save(Products products) {
        Session session = sessionFactory.getCurrentSession();
        session.save(products);
    }

    @Transactional
    public void update(int id, Products updatedProducts) {
        Session session = sessionFactory.getCurrentSession();
        Products productsToBeUpdated = session.get(Products.class, id);

        productsToBeUpdated.setName(updatedProducts.getName());
        productsToBeUpdated.setQuality(updatedProducts.getQuality());
        productsToBeUpdated.setPrice(updatedProducts.getPrice());
        productsToBeUpdated.setYear(updatedProducts.getYear());
        productsToBeUpdated.setProducer(updatedProducts.getProducer());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Products.class, id));
    }

    @Transactional()
    public List<Products> qualMax() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Products p where p.quality=(select max(pp.quality) from Products pp)", Products.class)
                        .getResultList();
    }


}
