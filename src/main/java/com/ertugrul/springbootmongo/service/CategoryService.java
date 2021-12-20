package com.ertugrul.springbootmongo.service;


import com.ertugrul.springbootmongo.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(String id) ;

    Category save(Category category);

    void delete(String id) ;
}
