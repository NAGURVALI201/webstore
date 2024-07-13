package com.example.demo1.dtos;

import com.example.demo1.model.Category;
import com.example.demo1.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public Product toProduct()
    {
        Product p = new Product();
        p.setId(this.getId());
        p.setTitle(this.getTitle());
        p.setDescription(this.getDescription());
        p.setPrice(this.getPrice());
        p.setImage(this.getImage());

        Category c = new Category();
        c.setName(this.getDescription());

        p.setCategory(c);

        return p;

    }
}
