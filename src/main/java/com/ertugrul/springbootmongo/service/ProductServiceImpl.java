package com.ertugrul.springbootmongo.service;

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
    public List<Product> findAll() {
        return productEntityService.findAll();
    }

    @Override
    public Product findById(String id) {
        return productEntityService.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productEntityService.save(product);
    }

    @Override
    public void deleteById(String id) {
        productEntityService.delete(id);
    }


}
