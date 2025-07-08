package com.micoservices.product.service;

import com.micoservices.product.DAO.ProductDAO;
import com.micoservices.product.DAO.interfaces.IProductDAO;
import com.micoservices.product.entity.Product;
import com.micoservices.product.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
    @Autowired
    private  IProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    @Override
    public UUID addProduct(Product product){
        return productDAO.addProduct(product);
    }
}
