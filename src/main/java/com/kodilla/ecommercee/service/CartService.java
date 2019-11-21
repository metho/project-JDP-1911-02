package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository repository;

    public void save(Cart cart){
        repository.save(cart);
    }

    public Optional<Cart> findById(Long id){
        return repository.findById(id);
    }

    public void deleteProductFromCart(Product product){
        //Tutaj muszę poczekać na endpoint Product
    }
}
