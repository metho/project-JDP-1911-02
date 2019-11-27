package com.kodilla.ecommercee.domain;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Long id;
    Map<Product, Integer> products = new HashMap<>();

    public CartDto(){}

    public CartDto(Long id, Map<Product, Integer> products) {
        this.id = id;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
