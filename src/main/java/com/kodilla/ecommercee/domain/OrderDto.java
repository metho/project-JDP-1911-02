package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private int orderNumber;
    private String productGroup;
    private int price;
    private List<Product> productList = new ArrayList<>();
    private User user;

}
