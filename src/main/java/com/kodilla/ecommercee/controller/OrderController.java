package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderEntity;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/order")

public class OrderController {

    @Autowired
    private OrderDbService service;

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping
    public List<OrderDto> getAllOrders () {
        return orderMapper.mapToOrderDtoList(service.getAllOrders());
    }
    @GetMapping ("/{orderId}")
    public OrderDto getOrderById (@PathVariable Long orderId){
        return orderMapper.mapToOrderDto(service.getOrderById(orderId));
    }
    @DeleteMapping
    public void deleteOrder (Long orderId){
        service.deleteById(orderId);
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createOrder (@RequestBody OrderDto orderDto) {
        service.saveOrder(orderMapper.mapToOrder(orderDto));
    }
    @PutMapping
    public OrderDto updateOrder (@RequestBody OrderDto groupDto){
        OrderEntity mapToOrderGroupDto = orderMapper.mapToOrder(groupDto);
        OrderEntity saveOrder = service.saveOrder(mapToOrderGroupDto);
        return orderMapper.mapToOrderDto(saveOrder);
    }
}
