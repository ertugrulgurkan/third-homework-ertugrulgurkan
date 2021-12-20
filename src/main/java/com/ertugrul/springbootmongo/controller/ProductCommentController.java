package com.ertugrul.springbootmongo.controller;


import com.ertugrul.springbootmongo.dto.ProductCommentDto;
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
    public List<ProductCommentDto> findAll() {
        return productCommentService.findAll();
    }

    @GetMapping("/{id}")
    public ProductCommentDto findById(@PathVariable String id) {
        return productCommentService.findById(id);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Object> save(@RequestBody ProductCommentDto productCommentDto) {
        productCommentDto = productCommentService.save(productCommentDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(productCommentDto.getId())
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
    public void delete(@RequestBody ProductCommentDto productCommentDto) {
        productCommentService.delete(productCommentDto);
    }
}
