package com.ertugrul.springbootmongo.service;

import com.ertugrul.springbootmongo.entity.Category;
import com.ertugrul.springbootmongo.service.entityservice.CategoryEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryEntityService categoryEntityService;

    public CategoryServiceImpl(CategoryEntityService categoryEntityService) {
        this.categoryEntityService = categoryEntityService;
    }

    public List<Category> findAll() {
        return categoryEntityService.findAll();
    }

    public Category findById(String id) {
        return categoryEntityService.findById(id);
    }

    public Category save(Category category) {
        return categoryEntityService.save(category);
    }

    public void delete(String id) {
        categoryEntityService.deleteById(id);
    }
}
