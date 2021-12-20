package com.ertugrul.springbootmongo.service;


import com.ertugrul.springbootmongo.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(String id);

    Product save(Product product);

    void deleteById(String id);

}
