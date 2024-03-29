package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public Cart mapToCart(CartDto cartDto) {
        return new Cart(cartDto.getId(), cartDto.getProducts());
    }
    public CartDto mapToCartDto(Cart cart){
        return new CartDto(cart.getId(), cart.getProducts());
    }
}
