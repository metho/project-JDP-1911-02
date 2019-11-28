package com.kodilla.ecommercee.domain;


import lombok.*;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartDto {
    private Long id;
    Map<Product, Integer> products = new HashMap<>();
}
