package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public OrderEntity mapToOrder (final OrderDto orderDto) {
        return new OrderEntity(
                orderDto.getId(),
                orderDto.getOrderNumber(),
                orderDto.getProductGroup(),
                orderDto.getPrice(),
                orderDto.getProductList(),
                orderDto.getUser()
        );
    }
    public OrderDto mapToOrderDto (final OrderEntity orderEntity) {
        return new OrderDto(
                orderEntity.getId(),
                orderEntity.getOrderNumber(),
                orderEntity.getProductGroup(),
                orderEntity.getPrice(),
                orderEntity.getProductList(),
                orderEntity.getUser()
        );
    }
    public List<OrderDto> mapToOrderDtoList(final List<OrderEntity> orderEntityList) {
        return orderEntityList.stream()
                .map(t->new OrderDto(t.getId(), t.getOrderNumber(), t.getProductGroup(), t.getPrice(), t.getProductList(), t.getUser()))
                .collect(Collectors.toList());
    }
}
