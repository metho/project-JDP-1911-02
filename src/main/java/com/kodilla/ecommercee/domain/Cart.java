package com.kodilla.ecommercee.domain;

import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ElementCollection
    @CollectionTable(name ="products_mapping",
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "product")
    @Column(name = "count")
    private Map<Product, Integer> products = new HashMap<>();

    public Cart(){}

    public Cart(Long id, Map<Product, Integer> products) {
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
