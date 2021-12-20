package com.ertugrul.springbootmongo.service.entityservice;


import com.ertugrul.springbootmongo.entity.Category;
import com.ertugrul.springbootmongo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryEntityService {

    private final CategoryRepository categoryRepository;

    public CategoryEntityService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(String id) {

        Optional<Category> optional = categoryRepository.findById(id);

        Category category = null;
        if (optional.isPresent()) {
            category = optional.get();
        }

        return category;
    }

    public void deleteById(String id) {
        categoryRepository.deleteById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}