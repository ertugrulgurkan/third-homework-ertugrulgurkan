package com.ertugrul.springbootmongo.service;


import com.ertugrul.springbootmongo.entity.ProductComment;

import java.util.List;

public interface ProductCommentService {

    List<ProductComment> findAll();

    ProductComment findById(String id);

    ProductComment save(ProductComment productComment);

    void deleteById(String id);

    void delete(ProductComment productComment);

}
