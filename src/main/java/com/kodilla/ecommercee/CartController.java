package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
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

    @RequestMapping(method = RequestMethod.GET)
    public Cart createEmptyCart(){
        return new Cart();
    }

    @RequestMapping(method = RequestMethod.GET)
    public CartDto getCartById(@RequestParam Long cartId){
        return cartMapper.mapToCartDto(Objects.requireNonNull(cartService.findById(cartId).orElse(null)));
    }

    @RequestMapping(method = RequestMethod.PUT, value="addProductToCart")
    public void addProductToCart(@RequestBody CartDto cartDto){
        cartService.save(cartMapper.mapToCart(cartDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value="deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestParam Long productId){
        cartService.deleteProductFromCart(cartId, productId);
    }
}