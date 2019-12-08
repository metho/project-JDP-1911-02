package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.GroupEntity;
import com.kodilla.ecommercee.domain.OrderEntity;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDbService {
    @Autowired
    private OrderRepository repository;

    public List<OrderEntity> getAllOrders() {
        return repository.findAll();
    }

    public OrderEntity getOrderById(Long id){
        return repository.findById(id).orElse(null);
    }

    public OrderEntity saveOrder(final OrderEntity orderEntity) {
        return repository.save(orderEntity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
