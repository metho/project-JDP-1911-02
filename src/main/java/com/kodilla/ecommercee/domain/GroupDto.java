package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.controller.ProductController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private long id;
    private Product product;
    private int productCount;
}
