package com.example.demo1.service;

import com.example.demo1.dtos.ProductDto;
import com.example.demo1.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreApi implements ProductService{
    private final RestTemplate restTemplate;

    public FakeStoreApi(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(long id)
    {
        ProductDto result = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                ProductDto.class);

        if(result==null)
        {
            return null;
        }
        return result.toProduct();
    }
    @Override
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }


}
