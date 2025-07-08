package com.micoservices.product.web.model.controller;

import com.micoservices.product.entity.Product;
import com.micoservices.product.interfaces.IProductService;
import com.micoservices.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private  IProductService productService;




    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @PostMapping("addProduct")
    @ResponseBody
    public ResponseEntity<UUID> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product),HttpStatus.CREATED);
    }
}
