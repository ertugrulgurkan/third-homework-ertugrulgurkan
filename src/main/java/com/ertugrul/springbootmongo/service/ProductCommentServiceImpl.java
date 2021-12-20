package com.ertugrul.springbootmongo.service;

import com.ertugrul.springbootmongo.entity.ProductComment;
import com.ertugrul.springbootmongo.service.entityservice.ProductCommentEntityService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductCommentServiceImpl implements ProductCommentService {

    private final ProductCommentEntityService productCommentEntityService;

    public ProductCommentServiceImpl(ProductCommentEntityService productCommentEntityService) {
        this.productCommentEntityService = productCommentEntityService;
    }

    @Override
    public List<ProductComment> findAll() {
        return productCommentEntityService.findAll();
    }

    @Override
    public ProductComment findById(String id) {
        return productCommentEntityService.findById(id);
    }

    @Override
    public ProductComment save(ProductComment productComment) {
        return productCommentEntityService.save(productComment);
    }

    @Override
    public void deleteById(String id) {
        productCommentEntityService.deleteById(id);
    }

    @Override
    public void delete(ProductComment productComment) {
        productCommentEntityService.delete(productComment);
    }
}
