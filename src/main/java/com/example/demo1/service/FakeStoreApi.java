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
        // due to type erasure at run time we can't use the collections in the json type in the api call.
        // since array don't use collections in the background their will not be a problem
       ProductDto[] results = restTemplate.getForObject("https://fakestoreapi.com/products",ProductDto[].class);

       List<Product> output = new ArrayList<>();

       if(results==null)
       {
           return new ArrayList<>();
       }
       for(ProductDto p : results)
       {
           output.add(p.toProduct());
       }

       return output;
    }


}
