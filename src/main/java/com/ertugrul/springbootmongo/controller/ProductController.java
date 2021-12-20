package com.ertugrul.springbootmongo.controller;

import com.ertugrul.springbootmongo.entity.Product;
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
@RequestMapping("/api/products/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public MappingJacksonValue findAllProductList() {

        List<Product> productList = productService.findAll();

        MappingJacksonValue mapping = new MappingJacksonValue(productList);

        return mapping;

    }

    @GetMapping("/{id}")
    public MappingJacksonValue findProductById(@PathVariable String id) {

        Product product = productService.findById(id);

        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllProductList()
        );

        EntityModel entityModel = EntityModel.of(product);

        entityModel.add(linkToProduct.withRel("all-products"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        return mapping;

//        return productService.findById(id);
    }

//    @GetMapping("/detail/{id}")
//    public ProductDetailDto findProductDetailDtoById(@PathVariable String id){
//        return productService.findProductDetailDtoById(id);
//    }

    @PostMapping("")
    public ResponseEntity<Object> saveProduct(/**@Valid*/@RequestBody Product product) {
        product = productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
    }

//    @GetMapping("categories/{categoryId}")
//    public List<ProductDetailDto> findAll
//    ByKategoriId(@PathVariable String categoryId){
//        return productService.findAllProductByCategoryId(categoryId);
//    }
}
