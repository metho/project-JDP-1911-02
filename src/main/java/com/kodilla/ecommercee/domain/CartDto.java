package com.kodilla.ecommercee.domain;


import lombok.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartDto {
    private Long id;
    Map<Product, Integer> products = new HashMap<>();
}
