package com.example.demo1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private Category category;
}
