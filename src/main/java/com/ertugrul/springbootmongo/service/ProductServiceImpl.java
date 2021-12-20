package com.ertugrul.springbootmongo.service;

import com.ertugrul.springbootmongo.converter.ProductConverter;
import com.ertugrul.springbootmongo.dto.ProductDto;
import com.ertugrul.springbootmongo.entity.Product;
import com.ertugrul.springbootmongo.service.entityservice.ProductEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductEntityService productEntityService;

    public ProductServiceImpl(ProductEntityService productEntityService) {
        this.productEntityService = productEntityService;
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList = productEntityService.findAll();
        return ProductConverter.INSTANCE.convertAllProductToProductDto(productList);
    }

    @Override
    public ProductDto findById(String id) {
        Product product = productEntityService.findById(id);
        return ProductConverter.INSTANCE.convertProductToProductDto(product);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = ProductConverter.INSTANCE.convertProductDtoToProduct(productDto);
        Product savedProduct = productEntityService.save(product);
        return ProductConverter.INSTANCE.convertProductToProductDto(savedProduct);
    }

    @Override
    public void deleteById(String id) {
        productEntityService.delete(id);
    }


}
