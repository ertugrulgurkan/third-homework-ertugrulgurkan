package com.ertugrul.springbootmongo.service;

import com.ertugrul.springbootmongo.converter.ProductCommentConverter;
import com.ertugrul.springbootmongo.dto.ProductCommentDto;
import com.ertugrul.springbootmongo.entity.ProductComment;
import com.ertugrul.springbootmongo.entity.ProductComment;
import com.ertugrul.springbootmongo.exception.CommentNotFoundException;
import com.ertugrul.springbootmongo.exception.CommentNotFoundException;
import com.ertugrul.springbootmongo.exception.ProductNotFoundException;
import com.ertugrul.springbootmongo.exception.UserNotFoundException;
import com.ertugrul.springbootmongo.service.entityservice.CategoryEntityService;
import com.ertugrul.springbootmongo.service.entityservice.ProductCommentEntityService;
import com.ertugrul.springbootmongo.service.entityservice.ProductEntityService;
import com.ertugrul.springbootmongo.service.entityservice.UserEntityService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductCommentServiceImpl implements ProductCommentService {

    private final UserEntityService userEntityService;
    
    private final ProductEntityService productEntityService;

    private final ProductCommentEntityService productCommentEntityService;

    public ProductCommentServiceImpl(UserEntityService userEntityService, ProductEntityService productEntityService, ProductCommentEntityService productCommentEntityService) {
        this.userEntityService = userEntityService;
        this.productEntityService = productEntityService;
        this.productCommentEntityService = productCommentEntityService;
    }

    @Override
    public List<ProductCommentDto> findAll() {
        List<ProductComment> productCommentList = productCommentEntityService.findAll();
        return ProductCommentConverter.INSTANCE.convertAllProductCommentListToProductCommentDtoList(productCommentList);
    }

    @Override
    public ProductCommentDto findById(String id) {
        ProductComment productComment = productCommentEntityService.findById(id);
        if (productComment == null)
            throw new CommentNotFoundException("Product Comment not found. id: " + id);
        return ProductCommentConverter.INSTANCE.convertProductCommentToProductCommentDto(productComment);
    }

    @Override
    public ProductCommentDto save(ProductCommentDto productCommentDto) {
        ProductComment productComment = ProductCommentConverter.INSTANCE.convertProductCommentDtoToProductComment(productCommentDto);
        if (userEntityService.findById(productCommentDto.getUserId()) == null)
            throw new UserNotFoundException("User not found.");

        if (productEntityService.findById(productCommentDto.getProductId()) == null)
            throw new ProductNotFoundException("Product not found.");
        ProductComment savedProductComment = productCommentEntityService.save(productComment);
        return ProductCommentConverter.INSTANCE.convertProductCommentToProductCommentDto(savedProductComment);
    }

    @Override
    public void deleteById(String id) {
        ProductComment productComment = productCommentEntityService.findById(id);
        if (productComment == null)
            throw new CommentNotFoundException("Product Comment not found. id: " + id);
        productCommentEntityService.deleteById(id);
    }

    @Override
    public void delete(ProductCommentDto productCommentDto) {
        ProductComment productComment = ProductCommentConverter.INSTANCE.convertProductCommentDtoToProductComment(productCommentDto);
        productComment = productCommentEntityService.findById(productComment.getId());
        if (productComment == null)
            throw new CommentNotFoundException("Product Comment id not found.");
        productCommentEntityService.delete(productComment);
    }
}
