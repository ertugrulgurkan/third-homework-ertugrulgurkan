package com.ertugrul.springbootmongo.controller;


import com.ertugrul.springbootmongo.entity.ProductComment;
import com.ertugrul.springbootmongo.service.ProductCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//Api üzerinden yorumlara erişmek için yazılmış controller sınıfı
@RestController
@RequestMapping("/api/comments")
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    public ProductCommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    // GET http://localhost:8080/api/comments
    @GetMapping(value = {"", "/"})
    public List<ProductComment> findAll() {
        return productCommentService.findAll();
    }

    @GetMapping("/{id}")
    public ProductComment findById(@PathVariable String id) {
        return productCommentService.findById(id);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Object> save(@RequestBody ProductComment productComment) {
        productComment = productCommentService.save(productComment);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(productComment.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    // Id parametresi ile yorum silebilecek servis
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        productCommentService.deleteById(id);
    }
    // Yorum silebilecek servis
    @DeleteMapping(value = {"", "/"})
    public void delete(@RequestBody ProductComment productComment) {
        productCommentService.delete(productComment);
    }
}
