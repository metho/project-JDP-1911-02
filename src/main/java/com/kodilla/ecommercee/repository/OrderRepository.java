package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    @Override
    Optional<OrderEntity> findById(Long id);
    @Override
    List<OrderEntity> findAll();
    @Override
    OrderEntity save (OrderEntity task);
    @Override
    void deleteById(Long id);
}
