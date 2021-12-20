package com.ertugrul.springbootmongo.controller;

import com.ertugrul.springbootmongo.entity.Category;
import com.ertugrul.springbootmongo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Api üzerinden kategorilere erişmek için yazılmış controller sınıfı
@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody Category category) {

        category = categoryService.save(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        categoryService.delete(id);
    }

}
