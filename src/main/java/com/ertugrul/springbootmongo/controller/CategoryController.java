package com.ertugrul.springbootmongo.controller;

import com.ertugrul.springbootmongo.dto.CategoryDto;
import com.ertugrul.springbootmongo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Api üzerinden kategorilere erişmek için yazılmış controller sınıfı
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = {"", "/"})
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto) {

        categoryDto = categoryService.save(categoryDto);

        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        categoryService.deleteById(id);
    }

}
