package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {
    public GroupEntity mapToGroup (final GroupDto groupDto) {
        return new GroupEntity(
                groupDto.getId(),
                groupDto.getProducts()
        );
    }
    public GroupDto mapToGroupDto (final GroupEntity groupEntity) {
        return new GroupDto(
                groupEntity.getId(),
                groupEntity.getProducts()
        );
    }
    public List<GroupDto> mapToGroupDtoList(final List<GroupEntity> groupEntityList) {
        System.out.println(groupEntityList);
        return groupEntityList.stream()
                .map(t->new GroupDto(t.getId(), t.getProducts()))
                .collect(Collectors.toList());
    }
}
