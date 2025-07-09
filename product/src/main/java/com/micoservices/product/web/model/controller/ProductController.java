package com.micoservices.product.web.model.controller;

import com.micoservices.product.entity.Product;
import com.micoservices.product.interfaces.IProductService;
import com.micoservices.product.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
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
    private IProductService productService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("addProduct")
    @ResponseBody
    public ResponseEntity<UUID> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("editProduct")
    @ResponseBody
    public ResponseEntity<?> editProduct(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(productService.editProduct(product), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{ProductId}/deleteProduct")
    @ResponseBody
    public ResponseEntity<?> deleteProduct(@PathVariable("ProductId") UUID productId) {
        try {
            productService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
