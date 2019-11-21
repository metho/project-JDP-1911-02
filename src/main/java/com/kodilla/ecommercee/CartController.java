package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    CartMapper cartMapper;

    @RequestMapping(method = RequestMethod.GET, value="createEmptyCart")
    public Cart createEmptyCart(){
        return new Cart();
    }

    @RequestMapping(method = RequestMethod.GET, value="getCartById")
    public Cart getCartById(@RequestParam Long cartId){
        return cartService.findById(cartId).orElse(null);
    }

    @RequestMapping(method = RequestMethod.PUT, value="addProductToCart")
    public void addProductToCart(@RequestBody CartDto cartDto){
        cartService.save(cartMapper.mapToTask(cartDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value="deleteProductFromCart")
    public void deleteProductFromCart(@RequestBody Product product){
        cartService.deleteProductFromCart(product);
    }
}