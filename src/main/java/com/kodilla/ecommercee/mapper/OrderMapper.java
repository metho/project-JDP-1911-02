package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupEntity;
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
                orderDto.getProductGroup()
        );
    }
    public OrderDto mapToOrderDto (final OrderEntity orderEntity) {
        return new OrderDto(
                orderEntity.getId(),
                orderEntity.getProductGroup()
        );
    }
    public List<OrderDto> mapToOrderDtoList(final List<OrderEntity> orderEntityList) {
        System.out.println(orderEntityList);
        return orderEntityList.stream()
                .map(t->new OrderDto(t.getId(), t.getProductGroup()))
                .collect(Collectors.toList());
    }
}
