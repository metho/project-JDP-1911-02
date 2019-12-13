package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartMapper cartMapper;

    @PostMapping
    public void createEmptyCart() {
        cartService.save(new Cart());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        cartService.save(cartMapper.mapToCart(cartDto));
    }

    @GetMapping
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