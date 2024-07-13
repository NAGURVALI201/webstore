package com.example.demo1.service;

import com.example.demo1.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
}
