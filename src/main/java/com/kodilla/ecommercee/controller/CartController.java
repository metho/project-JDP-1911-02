package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartMapper cartMapper;

    @GetMapping
    public Long createEmptyCart() {
        Cart cart = new Cart();
        cartService.save(cart);
        return cart.getId();
    }

    @GetMapping("/{cartId}")
    public CartDto getCartById(@RequestParam Long cartId) {
        return cartMapper.mapToCartDto(
                Objects.requireNonNull(
                        cartService.findById(cartId).orElse(null)
                )
        );
    }

    @PutMapping
    public void addProductToCart(@RequestBody CartDto cartDto){
        cartService.save(cartMapper.mapToCart(cartDto));
    }

    @DeleteMapping
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) {
        try{
            cartService.deleteProductFromCart(cartId, productId);
        } catch (IllegalArgumentException e){
            final Logger LOGGER = LoggerFactory.getLogger(getClass());
            LOGGER.error("Error: "+e);
        }
    }
}