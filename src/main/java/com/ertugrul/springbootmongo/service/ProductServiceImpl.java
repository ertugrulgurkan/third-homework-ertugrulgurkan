package com.ertugrul.springbootmongo.service;

import com.ertugrul.springbootmongo.converter.ProductConverter;
import com.ertugrul.springbootmongo.dto.ProductDto;
import com.ertugrul.springbootmongo.entity.Category;
import com.ertugrul.springbootmongo.entity.Product;
import com.ertugrul.springbootmongo.exception.CategoryNotFoundException;
import com.ertugrul.springbootmongo.exception.ProductNotFoundException;
import com.ertugrul.springbootmongo.service.entityservice.CategoryEntityService;
import com.ertugrul.springbootmongo.service.entityservice.ProductEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductEntityService productEntityService;

    private final CategoryEntityService categoryEntityService;

    public ProductServiceImpl(ProductEntityService productEntityService, CategoryEntityService categoryEntityService) {
        this.productEntityService = productEntityService;
        this.categoryEntityService = categoryEntityService;
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList = productEntityService.findAll();
        return ProductConverter.INSTANCE.convertAllProductToProductDto(productList);
    }

    @Override
    public ProductDto findById(String id) {
        Product product = productEntityService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found. id: " + id);
        }
        return ProductConverter.INSTANCE.convertProductToProductDto(product);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = ProductConverter.INSTANCE.convertProductDtoToProduct(productDto);
        Category category = categoryEntityService.findById(product.getCategoryId());
        if (category == null)
            throw new CategoryNotFoundException("Category not found. id: " + product.getCategoryId());
        Product savedProduct = productEntityService.save(product);
        return ProductConverter.INSTANCE.convertProductToProductDto(savedProduct);
    }

    @Override
    public void deleteById(String id) {
        Product product = productEntityService.findById(id);
        if (product == null)
            throw new ProductNotFoundException("Product not found. id: " + id);
        productEntityService.delete(id);
    }


}
