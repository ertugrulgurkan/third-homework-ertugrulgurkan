package com.ertugrul.springbootmongo.service;


import com.ertugrul.springbootmongo.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto findById(String id);

    CategoryDto save(CategoryDto categoryDto);

    void delete(String id);
}
