package com.micoservices.product.DAO.interfaces;

import com.micoservices.product.entity.Product;

import java.util.List;

public interface IProductDAO {
    public List<Product> findAll();
}
