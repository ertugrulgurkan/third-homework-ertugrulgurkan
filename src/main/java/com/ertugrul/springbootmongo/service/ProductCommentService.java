package com.ertugrul.springbootmongo.service;

import com.ertugrul.springbootmongo.dto.ProductCommentDto;

import java.util.List;

public interface ProductCommentService {

    List<ProductCommentDto> findAll();

    ProductCommentDto findById(String id);

    ProductCommentDto save(ProductCommentDto productCommentDto);

    void deleteById(String id);

    void delete(ProductCommentDto productCommentDto);

}
