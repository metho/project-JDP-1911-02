package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GroupMapper {
    public GroupEntity mapToTask (GroupDto groupDto) {
        Map<Product, Integer> products = new HashMap<>();
        products.put(groupDto.getProduct(), groupDto.getProductCount());

        return new GroupEntity(groupDto.getId(), products);
    }
}
