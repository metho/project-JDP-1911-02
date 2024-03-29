package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name ="CART")
    private Long id;

    @ElementCollection
    @CollectionTable(name ="products_mapping",
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "product")
    @Column(name = "count")
    private Map<Product, Integer> products = new HashMap<>();
}
