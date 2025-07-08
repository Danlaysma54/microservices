package com.micoservices.product.interfaces;

import com.micoservices.product.entity.Product;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    List<Product> getAllProducts();
    UUID addProduct(Product product);
}
