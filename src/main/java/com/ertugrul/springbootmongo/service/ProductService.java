package com.ertugrul.springbootmongo.service;


import com.ertugrul.springbootmongo.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(String id);

    ProductDto save(ProductDto productDto);

    void deleteById(String id);

}
