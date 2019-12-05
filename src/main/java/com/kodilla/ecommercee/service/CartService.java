package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository repository;

    public void save(Cart cart){
        repository.save(cart);
    }

    public Optional<Cart> findById(Long id){
        return repository.findById(id);
    }
    public void deleteProductFromCart(Long cartId, Long productId){
        Cart cart = findById(cartId).orElseThrow(() -> new IllegalArgumentException("Not found"));

        Map<Product, Integer> products = cart.getProducts();

        for(Map.Entry<Product, Integer> entry: cart.getProducts().entrySet()){
            if(entry.getKey().getId() == productId){
                products.remove(entry.getKey());
            }
        }

        cart.setProducts(products);

        save(cart);
    }
}
