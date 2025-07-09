package com.micoservices.product.DAO.interfaces;

import com.micoservices.product.entity.Product;

import java.util.List;
import java.util.UUID;

public interface IProductDAO {
    List<Product> findAll();

    UUID addProduct(Product product);

    Product editProduct(Product product);

    void deleteProduct(UUID productId);

    Product getProductById(UUID productId);
}
