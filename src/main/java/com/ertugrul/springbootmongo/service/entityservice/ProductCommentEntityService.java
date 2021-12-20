package com.ertugrul.springbootmongo.service.entityservice;


import com.ertugrul.springbootmongo.entity.ProductComment;
import com.ertugrul.springbootmongo.repository.ProductCommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductCommentEntityService {

    private final ProductCommentRepository productCommentRepository;

    public ProductCommentEntityService(ProductCommentRepository productCommentRepository) {
        this.productCommentRepository = productCommentRepository;
    }

    public List<ProductComment> findAll() {
        return productCommentRepository.findAll();
    }

    public ProductComment findById(String id) {

        Optional<ProductComment> optional = productCommentRepository.findById(id);

        ProductComment productComment = null;
        if (optional.isPresent()) {
            productComment = optional.get();
        }

        return productComment;
    }

    public void delete(ProductComment productComment) {
        productCommentRepository.delete(productComment);
    }

    public void deleteById(String id) {
        productCommentRepository.deleteById(id);
    }

    public ProductComment save(ProductComment productComment) {
        return productCommentRepository.save(productComment);
    }
}