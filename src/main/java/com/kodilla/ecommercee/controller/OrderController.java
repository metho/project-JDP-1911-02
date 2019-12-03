package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.DbService;
import com.kodilla.ecommercee.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderDbService service;

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping
    public List<OrderDto> getAllGroups () {
        return orderMapper.mapToOrderDtoList(service.getAllOrders());
    }
    @GetMapping ("/{orderId}")
    public OrderDto getGroupById (@PathVariable Long orderId){
        return orderMapper.mapToOrderDto(service.getOrderById(orderId));
    }
    @DeleteMapping
    public void deleteGroup (Long orderId){
        service.deleteById(orderId);
    }
    @PostMapping
    public void createGroup (@RequestBody OrderDto orderDto) {
        service.saveOrder(orderMapper.mapToOrder(orderDto));
    }
    @PutMapping
    public OrderDto updateTask (@RequestBody OrderDto groupDto){
        return orderMapper.mapToOrderDto(service.saveOrder(orderMapper.mapToOrder(groupDto)));
    }
}
