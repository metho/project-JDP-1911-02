package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartMapper {
    public Cart mapToTask(CartDto cartDto){
        Map<Product, Integer> products = new HashMap<>();
        products.put(cartDto.getProduct(), cartDto.getProductCount());

        return new Cart(cartDto.getId(), products);
    }

}
