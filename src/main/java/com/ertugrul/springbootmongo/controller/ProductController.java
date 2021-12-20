package com.ertugrul.springbootmongo.controller;

import com.ertugrul.springbootmongo.dto.ProductDto;
import com.ertugrul.springbootmongo.service.ProductService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Api üzerinden ürünlere erişmek için yazılmış controller sınıfı
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"", "/"})
    public MappingJacksonValue findAllProductList() {

        List<ProductDto> productList = productService.findAll();

        return new MappingJacksonValue(productList);

    }

    @GetMapping("/{id}")
    public MappingJacksonValue findProductById(@PathVariable String id) {

        ProductDto product = productService.findById(id);

        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllProductList()
        );

        EntityModel<ProductDto> entityModel = EntityModel.of(product);

        entityModel.add(linkToProduct.withRel("all-products"));

        return new MappingJacksonValue(entityModel);

    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto) {
        productDto = productService.save(productDto);

        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
    }

}
