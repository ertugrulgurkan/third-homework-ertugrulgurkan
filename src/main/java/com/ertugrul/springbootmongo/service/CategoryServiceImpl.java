package com.ertugrul.springbootmongo.service;

import com.ertugrul.springbootmongo.converter.CategoryConverter;
import com.ertugrul.springbootmongo.dto.CategoryDto;
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

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryEntityService.findAll();
        return CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDtoList(categoryList);
    }

    @Override
    public CategoryDto findById(String id) {
        Category category = categoryEntityService.findById(id);
        return CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);
        Category savedCategory = categoryEntityService.save(category);
        return CategoryConverter.INSTANCE.convertCategoryToCategoryDto(savedCategory);
    }

    @Override
    public void delete(String id) {
        categoryEntityService.deleteById(id);
    }
}
