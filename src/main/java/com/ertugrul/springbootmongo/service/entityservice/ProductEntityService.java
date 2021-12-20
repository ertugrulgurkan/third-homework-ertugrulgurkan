package com.ertugrul.springbootmongo.service.entityservice;

import com.ertugrul.springbootmongo.entity.Product;
import com.ertugrul.springbootmongo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductEntityService {

    private final ProductRepository productRepository;

    public ProductEntityService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {

        Optional<Product> optional = productRepository.findById(id);

        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        }

        return product;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllProductByCategoryId(String categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

}
