package com.micoservices.product.DAO;

import com.micoservices.product.DAO.interfaces.IProductDAO;
import com.micoservices.product.entity.Product;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductDAO implements IProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return (List<Product>) session.createQuery("from Product").list();
        }
    }

    @Override
    public UUID addProduct(Product product) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.persist(product);
            tx1.commit();
            return product.getId();
        }

    }

    @Override
    public Product editProduct(Product product) {
        try (Session session = sessionFactory.openSession()) {

            Transaction tx2 = session.beginTransaction();
            Product pr = session.merge(product);
            tx2.commit();
            return pr;
        }
    }

    @Override
    public void deleteProduct(UUID productId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(productId);
        }
    }

    @Override
    public Product getProductById(UUID productId) {
        try (Session session = sessionFactory.openSession()) {

            if (session.get(Product.class, productId) == null) {
                throw new NullPointerException("There is no product with that id");
            }
        }
    }
}