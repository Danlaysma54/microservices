package com.micoservices.product.DAO;

import com.micoservices.product.DAO.interfaces.IProductDAO;
import com.micoservices.product.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDAO implements IProductDAO {
    @Autowired
    private  SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {
        return (List<Product>)
                sessionFactory.openSession().getSessionFactory()
                        .openSession().createQuery("from Product")
                        .list();
    }
}
