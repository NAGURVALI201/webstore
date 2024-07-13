package com.example.demo1.controllers;


import com.example.demo1.model.Product;
import com.example.demo1.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    private Product getProduct(@PathVariable("id") long id)
    {
        return productService.getProductById(id);
    }

    @GetMapping("")
    private List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

}
