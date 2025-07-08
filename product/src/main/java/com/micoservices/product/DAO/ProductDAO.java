package com.micoservices.product.DAO;

import com.micoservices.product.DAO.interfaces.IProductDAO;
import com.micoservices.product.entity.Product;
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
        return (List<Product>)
                sessionFactory.openSession().createQuery("from Product")
                        .list();
    }

    @Override
    public UUID addProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        UUID addedProduct = (UUID) session.save(product);
        tx1.commit();
        session.close();
        return addedProduct;

    }
}
