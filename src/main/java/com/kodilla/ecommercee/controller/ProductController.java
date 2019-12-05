package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("v1/product")
public class ProductController {

    public ProductController(){

    }

    @Autowired
    private ProductService service;
    @Autowired
    private ProductMapper productMapper;


    @GetMapping
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping("/(productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return new ProductDto(1L, "pants", 100);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        productDto = new ProductDto(1L, "pants", 100);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productDto = new ProductDto(1L, "pants", 150);
    }

    @DeleteMapping
    public void deleteProduct(@PathVariable Long productId) {
        service.deleteProduct(productId);
    }
}